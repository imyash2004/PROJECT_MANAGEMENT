
import axios from 'axios';

// Environment-based API URL configuration
const getApiBaseUrl = () => {
  if (import.meta.env.PROD) {
    // Production: Use environment variable or fallback
    return import.meta.env.VITE_API_BASE_URL || 'https://your-backend-url.onrender.com';
  } else {
    // Development: Use localhost
    return 'http://localhost:5054';
  }
};

export const API_BASE_URL = getApiBaseUrl();

const api = axios.create({
  baseURL: API_BASE_URL,
  timeout: 15000, // Increased timeout for production
});

// Use interceptors to dynamically set the Authorization header
api.interceptors.request.use(
  config => {
    const token = localStorage.getItem('jwt');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
      console.log('Adding token to request:', config.url);
    } else {
      console.log('No token available for request:', config.url);
    }
    return config;
  },
  error => {
    console.error('Request interceptor error:', error);
    return Promise.reject(error);
  }
);

// Add response interceptor for better error handling
api.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    if (error.response) {
      // The request was made and the server responded with a status code
      // that falls out of the range of 2xx
      console.error('Response error:', error.response.status, error.response.data);
      
      // If unauthorized (token issues), clear token and redirect to login
      if (error.response.status === 401) {
        console.error('Authentication error - clearing token');
        localStorage.removeItem('jwt');
        // Redirect to login page
        if (window.location.pathname !== '/signin') {
          window.location.href = '/signin';
        }
      }
    } else if (error.request) {
      // The request was made but no response was received
      console.error('No response received:', error.request);
    } else {
      // Something happened in setting up the request
      console.error('Request setup error:', error.message);
    }
    return Promise.reject(error);
  }
);

api.defaults.headers.post['Content-Type'] = 'application/json';

export default api;
