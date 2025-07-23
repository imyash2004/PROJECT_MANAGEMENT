import axios from 'axios';
import {
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAILURE,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAILURE,
  GET_USER_REQUEST,
  GET_USER_SUCCESS,
  GET_USER_FAILURE,
  LOGOUT
} from './ActionTypes';
import api, { API_BASE_URL } from '@/Api/api';

// Register action creators
const registerRequest = () => ({ type: REGISTER_REQUEST });
const registerSuccess = (user) => ({ type: REGISTER_SUCCESS, payload:user });
const registerFailure = error => ({ type: REGISTER_FAILURE, payload: error });

export const register = userData => async dispatch => {
  dispatch(registerRequest());
  try {
    // Use api instance instead of axios directly to use interceptors
    const response = await api.post('/api/auth/signup', userData);
    const user = response.data;
    if(user.jwt) {
      localStorage.setItem("jwt", user.jwt);
      console.log("JWT stored in localStorage:", user.jwt);
    }
    console.log("register success:- ", user);
    dispatch(registerSuccess(user));
  } catch (error) {
    console.log("error ", error);
    dispatch(registerFailure(error.response?.data?.message || error.message));
  }
};

// Login action creators
const loginRequest = () => ({ type: LOGIN_REQUEST });
const loginSuccess = user => ({ type: LOGIN_SUCCESS, payload: user });
const loginFailure = error => ({ type: LOGIN_FAILURE, payload: error });

export const login = userData => async dispatch => {
  dispatch(loginRequest());
  try {
    // Use the endpoint that's explicitly allowed in the security config
    const response = await api.post('/api/auth/signin', userData);
    const user = response.data;
    if(user.jwt) {
      localStorage.setItem("jwt", user.jwt);
      console.log("JWT stored in localStorage:", user.jwt);
    } else {
      console.warn("No JWT in login response:", user);
    }
    console.log("login success", user);
    dispatch(loginSuccess(user));
  } catch (error) {
    console.log("login error", error);
    dispatch(loginFailure(error.response?.data?.message || error.message));
  }
};



//  get user from token
export const getUser = (token) => {
  return async (dispatch) => {
    dispatch({ type: GET_USER_REQUEST });
    try {
      // Token is already set by the interceptor if it exists in localStorage
      const response = await api.get('/api/users/profile');
      const user = response.data;
      dispatch({ type: GET_USER_SUCCESS, payload: user });
      console.log("req User ", user);
    } catch (error) {
      console.error("Error getting user profile:", error);
      const errorMessage = error.response?.data?.message || error.message;
      dispatch({ type: GET_USER_FAILURE, payload: errorMessage });
    }
  };
};

export const logout = () => {
    return async (dispatch) => {
      dispatch({ type: LOGOUT });
      localStorage.clear();
    };
  };
