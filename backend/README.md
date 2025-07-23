# Backend - Project Management System

A robust Spring Boot backend API for the Project Management System, providing secure authentication, project management, issue tracking, and team collaboration features.

## 🚀 Features

- **RESTful API Architecture**
  - Clean, well-documented REST endpoints
  - JSON request/response format
  - Proper HTTP status codes and error handling

- **Security & Authentication**
  - JWT-based authentication
  - Role-based authorization (ADMIN/USER)
  - Password encryption with BCrypt
  - CORS configuration for cross-origin requests

- **Database Management**
  - JPA/Hibernate ORM for database operations
  - MySQL database with optimized queries
  - Database migrations and schema management
  - Connection pooling and transaction management

- **Email Integration**
  - Team invitation emails via SMTP
  - Email template support
  - Async email processing

- **Payment Integration**
  - Razorpay payment gateway integration
  - Subscription management
  - Payment verification and handling

## 🛠️ Tech Stack

### Core Framework
- **Spring Boot 3.1+** - Main application framework
- **Spring Web** - RESTful web services
- **Spring Data JPA** - Data persistence layer
- **Spring Security** - Authentication and authorization

### Database & Persistence
- **MySQL8** - Primary database
- **Hibernate** - ORM framework
- **HikariCP** - Connection pooling

### Security
- **JWT (jsonwebtoken)** - Token-based authentication
- **BCrypt** - Password hashing
- **Spring Security** - Security framework

### Utilities
- **Lombok** - Code generation
- **Jackson** - JSON processing
- **JavaMail** - Email services
- **Maven** - Dependency management

## 📁 Project Structure

```
backend/
├── src/main/java/com/yashh/
│   ├── ProjectmanagementApplication.java  # Main application class
│   ├── controller/              # REST Controllers
│   │   ├── AuthController.java          # Authentication endpoints
│   │   ├── ProjectController.java       # Project management
│   │   ├── IssueController.java         # Issue tracking
│   │   ├── UserController.java          # User management
│   │   ├── SubscriptionController.java  # Subscription management
│   │   ├── PaymentController.java       # Payment processing
│   │   ├── MessageController.java       # Chat/messaging
│   │   └── CommentController.java       # Issue comments
│   ├── service/                 # Business Logic Layer
│   │   ├── UserService.java             # User operations
│   │   ├── ProjectService.java          # Project operations
│   │   ├── IssueService.java            # Issue operations
│   │   ├── SubscriptionService.java     # Subscription logic
│   │   ├── PaymentService.java          # Payment processing
│   │   ├── EmailService.java            # Email operations
│   │   ├── InvitationService.java       # Invitation handling
│   │   └── CustomUserDetailsService.java # User details for security
│   ├── model/                   # Data Models/Entities
│   │   ├── User.java                    # User entity
│   │   ├── Project.java                 # Project entity
│   │   ├── Issue.java                   # Issue entity
│   │   ├── Comment.java                 # Comment entity
│   │   ├── Chat.java                    # Chat entity
│   │   ├── Message.java                 # Message entity
│   │   ├── Subscription.java            # Subscription entity
│   │   ├── PlanType.java                # Subscription plan enum
│   │   └── Invitation.java              # Invitation entity
│   ├── repository/              # Data Access Layer
│   │   ├── UserRepository.java          # User data access
│   │   ├── ProjectRepository.java       # Project data access
│   │   ├── IssueRepository.java         # Issue data access
│   │   ├── CommentRepository.java       # Comment data access
│   │   ├── ChatRepository.java          # Chat data access
│   │   ├── MessageRepository.java       # Message data access
│   │   ├── SubscriptionRepository.java  # Subscription data access
│   │   └── InviteTokenRepository.java   # Invitation data access
│   ├── config/                  # Configuration Classes
│   │   ├── AppConfig.java               # Security & CORS configuration
│   │   ├── JwtProvider.java             # JWT token utilities
│   │   ├── JwtConstant.java             # JWT constants
│   │   ├── JwtTokenValidator.java       # JWT validation filter
│   │   └── WebsocketConfig.java         # WebSocket configuration
│   ├── request/                 # Request DTOs
│   │   ├── CreateCommentRequest.java    # Comment creation
│   │   ├── CreateIssueRequest.java      # Issue creation
│   │   ├── IssueRequest.java            # Issue updates
│   │   ├── LoginRequest.java            # User login
│   │   ├── MessageRequest.java          # Chat messages
│   │   └── ProjectInvitationRequest.java # Project invitations
│   ├── response/                # Response DTOs
│   │   ├── AuthResponse.java            # Authentication response
│   │   ├── MessageResponse.java         # General message response
│   │   └── PaymentLinkResponse.java     # Payment link response
│   └── exception/               # Custom Exceptions
│       ├── UserException.java           # User-related exceptions
│       ├── ProjectException.java        # Project-related exceptions
│       ├── IssueException.java          # Issue-related exceptions
│       ├── ChatException.java           # Chat-related exceptions
│       └── MailsException.java          # Email-related exceptions
├── src/main/resources/
│   ├── application.properties           # Application configuration
│   ├── static/                          # Static resources
│   └── templates/                       # Email templates
├── src/test/java/                       # Test classes
├── target/                              # Build output
├── pom.xml                              # Maven dependencies
└── README.md                            # This file
```

## 🚦 Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven 3.6+** for dependency management
- **MySQL 8** for database
- **SMTP Email Account** (Gmail recommended)
- **Razorpay Account** (for payment features)

### Installation & Setup

1. **Clone and navigate to backend**
   ```bash
   cd backend
   ```

2. **Database Setup**
   ```sql
   CREATE DATABASE projectmanagement;
   CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON projectmanagement.* TO 'your_username'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **Configure Application Properties**
   
   Update `src/main/resources/application.properties`:
   ```properties
   # Server Configuration
   server.port=5054
   spring.application.name=PROJECT-MANAGEMENT

   # Database Configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/projectmanagement
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update

   # Email Configuration
   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=your_email@gmail.com
   spring.mail.password=your_app_password
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true

   # Payment Gateway Configuration
   razorpay.api.key=your_razorpay_key
   razorpay.api.secret=your_razorpay_secret
   ```

4. **Install Dependencies & Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Verify Installation**
   ```
   Backend API: http://localhost:5054
   Health Check: http://localhost:5054/actuator/health (if actuator enabled)
   ```

## 📋 Available Scripts

### Maven Commands
```bash
mvn clean                # Clean build artifacts
mvn compile              # Compile source code
mvn test                 # Run unit tests
mvn package              # Create JAR file
mvn spring-boot:run      # Run application
mvn clean install       # Clean, compile, test, and package
```

### Development Tools
```bash
mvn spring-boot:run -Dspring.profiles.active=dev    # Run with dev profile
mvn test -Dtest=UserServiceTest                     # Run specific test
mvn clean package -DskipTests                      # Package without tests
```

## 🔌 API Endpoints

### Authentication Endpoints
```bash
POST   /api/auth/signup     # User registration
POST   /api/auth/signin     # User login
POST   /api/auth/login      # Alternative login endpoint
GET    /api/users/profile   # Get user profile
```

### Project Management
```bash
GET    /api/projects                    # Get all user projects
POST   /api/projects                    # Create new project
GET    /api/projects/{id}               # Get project by ID
PUT    /api/projects/{id}               # Update project
DELETE /api/projects/{id}               # Delete project
GET    /api/projects/search             # Search projects
POST   /api/projects/invite             # Invite user to project
GET    /api/projects/accept_invitation  # Accept project invitation
GET    /api/projects/{id}/chat          # Get project chat
```

### Issue Management
```bash
GET    /api/issues/project/{projectId}  # Get project issues
POST   /api/issues                      # Create new issue
GET    /api/issues/{id}                 # Get issue details
PUT    /api/issues/{id}                 # Update issue
DELETE /api/issues/{id}                 # Delete issue
PUT    /api/issues/{id}/assignee/{userId} # Assign issue
PUT    /api/issues/{id}/status/{status} # Update issue status
```

### Comments
```bash
POST   /api/comments                    # Create comment
DELETE /api/comments/{id}               # Delete comment
GET    /api/comments/{issueId}          # Get issue comments
```

### Messaging & Chat
```bash
POST   /api/messages/send               # Send message
GET    /api/messages/chat/{chatId}      # Get chat messages
```

### Subscription & Payment
```bash
GET    /api/subscriptions/user         # Get user subscription
POST   /api/payments/{planType}        # Create payment link
```

## 🔐 Security Configuration

### JWT Configuration
- **Secret Key**: Configurable in `JwtConstant.java`
- **Token Expiration**: 24 hours (configurable)
- **Header Name**: Authorization
- **Token Format**: Bearer {token}

### CORS Configuration
```java
// Allowed Origins
"http://localhost:5173"                          // Development
"https://project-management-react-plum.vercel.app" // Production

// Allowed Methods
GET, POST, PUT, DELETE, OPTIONS, PATCH

// Allowed Headers
Authorization, Content-Type, Accept
```

### Security Rules
```java
/api/auth/register, /api/auth/login, /api/auth/signin    // Public
/api/admin/**                                            // ADMIN role required
/api/**                                                  // Authentication required
```

## 🗄️ Database Schema

### Key Entities and Relationships

```sql
-- Users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    full_name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);

-- Projects table
CREATE TABLE projects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    owner_id BIGINT,
    FOREIGN KEY (owner_id) REFERENCES users(id)
);

-- Issues table
CREATE TABLE issues (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    priority VARCHAR(50),
    due_date DATE,
    project_id BIGINT,
    assignee_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES projects(id),
    FOREIGN KEY (assignee_id) REFERENCES users(id)
);
```

## 🧪 Testing

### Unit Tests
```bash
mvn test                                    # Run all tests
mvn test -Dtest=UserServiceTest            # Run specific test class
mvn test -Dtest=UserServiceTest#testCreate # Run specific test method
```

### Test Categories
- **Controller Tests**: API endpoint testing
- **Service Tests**: Business logic testing
- **Repository Tests**: Data access testing
- **Integration Tests**: End-to-end testing

### Test Configuration
```properties
# Test Database (H2 in-memory)
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop
```

## 📧 Email Configuration

### Gmail SMTP Setup
1. Enable 2-Factor Authentication
2. Generate App Password
3. Use app password in configuration

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## 💳 Payment Integration

### Razorpay Setup
1. Create Razorpay account
2. Get API keys from dashboard
3. Configure in application.properties

```java
// Payment Service Implementation
@Service
public class PaymentService {
    public PaymentLinkResponse createPaymentLink(User user, Long amount, String planType) {
        // Razorpay payment link creation logic
    }
}
```

## 🚀 Deployment

### Build for Production
```bash
mvn clean package -DskipTests
```

### Run JAR File
```bash
java -jar target/projectmanagement-0.0.1-SNAPSHOT.jar
```

### Docker Deployment
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/projectmanagement-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5054
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Environment Variables
```bash
SPRING_DATASOURCE_URL=jdbc:mysql://prod-db:3306/projectmanagement
SPRING_DATASOURCE_USERNAME=prod_user
SPRING_DATASOURCE_PASSWORD=prod_password
SPRING_MAIL_USERNAME=your_email@gmail.com
SPRING_MAIL_PASSWORD=your_app_password
RAZORPAY_API_KEY=your_prod_key
RAZORPAY_API_SECRET=your_prod_secret
```

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   ```
   Solution: Check MySQL is running and credentials are correct
   ```

2. **JWT Token Issues**
   ```
   Solution: Verify JWT secret key and token format
   ```

3. **Email Sending Failures**
   ```
   Solution: Check SMTP configuration and app password
   ```

4. **CORS Errors**
   ```
   Solution: Update allowed origins in AppConfig.java
   ```

### Logging Configuration
```properties
# Enable debug logging
logging.level.com.yashh=DEBUG
logging.level.org.springframework.security=DEBUG
logging.level.org.springframework.web=DEBUG
```

## 📊 Monitoring & Health Checks

### Actuator Endpoints (if enabled)
```bash
GET /actuator/health      # Application health
GET /actuator/info        # Application info
GET /actuator/metrics     # Application metrics
```

## 🔮 Future Enhancements

- [ ] Redis caching for improved performance
- [ ] Message queue integration (RabbitMQ/Kafka)
- [ ] Advanced logging with ELK stack
- [ ] API rate limiting
- [ ] Swagger/OpenAPI documentation
- [ ] Database clustering and replication
- [ ] Microservices architecture migration
- [ ] WebSocket real-time notifications

## 🤝 Contributing

1. Follow Spring Boot best practices
2. Write unit tests for new features
3. Use proper exception handling
4. Follow naming conventions
5. Document API changes

## 📞 Support

For backend-specific issues:
- Check application logs
- Verify database connectivity
- Review API documentation
- Contact: agarwalyash041@gmail.com

## 📝 API Documentation

For detailed API documentation, consider integrating Swagger/OpenAPI:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.2</version>
</dependency>
```


