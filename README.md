# Project Management System

A comprehensive full-stack web application for project management with team collaboration features, built with React.js frontend and Spring Boot backend.

## 🚀 Features

- **User Authentication & Authorization**
  - User registration and login with JWT authentication
  - Role-based access control (Admin/User)
  - Secure password encryption

- **Project Management**
  - Create and manage multiple projects
  - Project dashboard with detailed analytics
  - Project search and filtering capabilities

- **Team Collaboration**
  - Invite team members via email
  - Real-time chat and messaging
  - Team member management and permissions

- **Issue Tracking**
  - Create, assign, and track issues
  - Issue status management (Open, In Progress, Done)
  - Comments and discussions on issues
  - Issue prioritization and categorization

- **Subscription Management**
  - Multiple subscription plans
  - Payment integration with Razorpay
  - Feature access based on subscription tier

## 🛠️ Tech Stack

### Frontend
- **React.js 18** - Modern UI framework
- **Redux Toolkit** - State management
- **Tailwind CSS** - Utility-first CSS framework
- **Shadcn/UI** - Component library
- **Axios** - HTTP client
- **React Router Dom** - Client-side routing
- **React Hook Form** - Form handling
- **Zod** - Schema validation

### Backend
- **Spring Boot 3** - Java application framework
- **Spring Security 6** - Authentication & Authorization
- **Spring Data JPA** - Database operations
- **MySQL 8** - Relational database
- **JWT** - Token-based authentication
- **JavaMail** - Email service integration
- **Lombok** - Code generation library

## 📁 Project Structure

```
Project Management/
├── frontend/                 # React.js frontend application
│   ├── src/
│   │   ├── components/      # Reusable UI components
│   │   ├── pages/          # Page components
│   │   ├── redux/          # State management
│   │   ├── Api/            # API configuration
│   │   └── lib/            # Utility functions
│   ├── public/             # Static assets
│   └── package.json        # Frontend dependencies
├── backend/                 # Spring Boot backend application
│   ├── src/main/java/      # Java source code
│   │   └── com/yashh/      # Main package
│   │       ├── controller/ # REST controllers
│   │       ├── service/    # Business logic
│   │       ├── model/      # Data models
│   │       ├── repository/ # Data access layer
│   │       └── config/     # Configuration classes
│   ├── src/main/resources/ # Configuration files
│   └── pom.xml            # Backend dependencies
└── README.md              # This file
```

## 🚦 Getting Started

### Prerequisites

- **Node.js** (v16 or higher)
- **Java** (v17 or higher)
- **MySQL** (v8 or higher)
- **Maven** (v3.6 or higher)
- **Git** (for version control)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd "Project Management"
   ```

2. **Database Setup**
   ```sql
   CREATE DATABASE projectmanagement;
   ```

3. **Backend Setup**
   ```bash
   cd backend
   # Update application.properties with your database credentials
   mvn clean install
   mvn spring-boot:run
   ```
   Backend will run on: `http://localhost:5054`

4. **Frontend Setup**
   ```bash
   cd frontend
   npm install
   npm run dev
   ```
   Frontend will run on: `http://localhost:5173`

## 🔧 Configuration

### Backend Configuration

Update `backend/src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=5054

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/projectmanagement
spring.datasource.username=your_username
spring.datasource.password=your_password

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password

# Payment Gateway (Razorpay)
razorpay.api.key=your_razorpay_key
razorpay.api.secret=your_razorpay_secret
```

### Frontend Configuration

The frontend automatically connects to the backend API. If needed, update the API base URL in `frontend/src/Api/api.js`:

```javascript
const LOCALHOST = 'http://localhost:5054'
export const API_BASE_URL = LOCALHOST
```

## 📚 API Endpoints

### Authentication
- `POST /api/auth/signup` - User registration
- `POST /api/auth/signin` - User login

### Projects
- `GET /api/projects` - Get all projects
- `POST /api/projects` - Create new project
- `GET /api/projects/{id}` - Get project by ID
- `PUT /api/projects/{id}` - Update project
- `DELETE /api/projects/{id}` - Delete project
- `POST /api/projects/invite` - Invite user to project

### Issues
- `GET /api/issues/project/{projectId}` - Get project issues
- `POST /api/issues` - Create new issue
- `PUT /api/issues/{id}` - Update issue
- `DELETE /api/issues/{id}` - Delete issue

### Users
- `GET /api/users/profile` - Get user profile
- `PUT /api/users/profile` - Update user profile

## 🧪 Testing

### Backend Tests
```bash
cd backend
mvn test
```

### Frontend Tests
```bash
cd frontend
npm test
```

## 🚀 Deployment

### Backend Deployment
```bash
cd backend
mvn clean package
java -jar target/projectmanagement-0.0.1-SNAPSHOT.jar
```

### Frontend Deployment
```bash
cd frontend
npm run build
# Deploy the dist/ folder to your hosting service
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Authors

- **Yash Agarwal** - *Initial work* - [GitHub Profile](https://github.com/yashagarwal)

## 🐛 Known Issues

- Email notifications may fail if SMTP configuration is incorrect
- Real-time features require WebSocket connection
- Some features require specific subscription plans

## 📞 Support

For support, email: agarwalyash041@gmail.com

## 🔮 Future Enhancements

- [ ] Mobile application development
- [ ] Advanced analytics and reporting
- [ ] Integration with third-party tools (Slack, Discord)
- [ ] File upload and management
- [ ] Advanced project templates
- [ ] Time tracking features
