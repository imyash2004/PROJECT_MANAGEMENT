# Frontend - Project Management System

A modern React.js frontend application for the Project Management System with a beautiful, responsive UI built using Tailwind CSS and Shadcn/UI components.

## 🚀 Features

- **Modern React Architecture**
  - React 18 with hooks and functional components
  - Redux Toolkit for efficient state management
  - React Router for seamless navigation

- **Beautiful User Interface**
  - Responsive design that works on all devices
  - Dark/Light theme support
  - Modern component library (Shadcn/UI)
  - Tailwind CSS for rapid styling

- **User Experience**
  - Form validation with React Hook Form and Zod
  - Loading states and error handling
  - Toast notifications for user feedback
  - Intuitive navigation and user flows

- **Real-time Features**
  - Live chat and messaging
  - Real-time notifications
  - WebSocket integration for instant updates

## 🛠️ Tech Stack

### Core Technologies
- **React.js 18** - Frontend framework
- **Vite** - Build tool and dev server
- **TypeScript/JavaScript** - Programming language

### State Management
- **Redux Toolkit** - State management
- **Redux Persist** - State persistence

### UI & Styling
- **Tailwind CSS** - Utility-first CSS framework
- **Shadcn/UI** - Component library
- **Lucide React** - Icon library
- **Radix UI** - Primitive components

### Forms & Validation
- **React Hook Form** - Form handling
- **Zod** - Schema validation
- **@hookform/resolvers** - Form validation integration

### HTTP & API
- **Axios** - HTTP client
- **React Query** - Server state management (if implemented)

### Routing
- **React Router Dom** - Client-side routing

## 📁 Project Structure

```
frontend/
├── public/                  # Static assets
│   ├── vite.svg
│   └── index.html
├── src/
│   ├── components/         # Reusable UI components
│   │   ├── ui/            # Base UI components (Shadcn/UI)
│   │   └── custom/        # Custom components
│   ├── pages/             # Page components
│   │   ├── Auth/          # Authentication pages
│   │   ├── Home/          # Home page
│   │   ├── Project/       # Project-related pages
│   │   ├── Issue/         # Issue management pages
│   │   ├── Navbar/        # Navigation components
│   │   └── sidebar/       # Sidebar components
│   ├── redux/             # State management
│   │   ├── Store.js       # Redux store configuration
│   │   ├── Auth/          # Authentication state
│   │   ├── Project/       # Project state
│   │   ├── Issue/         # Issue state
│   │   ├── Chat/          # Chat state
│   │   └── Subscription/  # Subscription state
│   ├── Api/               # API configuration
│   │   └── api.js         # Axios configuration
│   ├── lib/               # Utility functions
│   │   └── utils.js       # Common utilities
│   ├── assets/            # Static assets
│   ├── App.jsx            # Main App component
│   ├── main.jsx           # Entry point
│   └── index.css          # Global styles
├── components.json         # Shadcn/UI configuration
├── tailwind.config.js     # Tailwind configuration
├── vite.config.js         # Vite configuration
├── package.json           # Dependencies and scripts
└── README.md              # This file
```

## 🚦 Getting Started

### Prerequisites

- **Node.js** (v16 or higher)
- **npm** or **yarn** package manager

### Installation

1. **Navigate to frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   # or
   yarn install
   ```

3. **Environment Setup**
   
   The API base URL is configured in `src/Api/api.js`. Update if your backend runs on a different port:
   ```javascript
   const LOCALHOST = 'http://localhost:5054'
   export const API_BASE_URL = LOCALHOST
   ```

4. **Start development server**
   ```bash
   npm run dev
   # or
   yarn dev
   ```

5. **Open in browser**
   ```
   http://localhost:5173
   ```

## 📦 Available Scripts

### Development
```bash
npm run dev          # Start development server
npm run preview      # Preview production build locally
```

### Building
```bash
npm run build        # Build for production
npm run build:dev    # Build for development
```

### Code Quality
```bash
npm run lint         # Run ESLint
npm run lint:fix     # Fix ESLint errors
npm run format       # Format code with Prettier
```

### Testing
```bash
npm run test         # Run tests
npm run test:watch   # Run tests in watch mode
npm run test:coverage # Run tests with coverage
```

## 🎨 UI Components

### Shadcn/UI Components Used
- **Avatar** - User profile pictures
- **Badge** - Status indicators
- **Button** - Interactive buttons
- **Card** - Content containers
- **Dialog** - Modal dialogs
- **Drawer** - Side panels
- **Form** - Form components
- **Input** - Text inputs
- **Select** - Dropdown selectors
- **Tabs** - Tab navigation
- **Sheet** - Sliding panels

### Custom Components
- **Navbar** - Application navigation
- **Sidebar** - Side navigation
- **IssueList** - Issue display component
- **ChatBox** - Real-time chat interface
- **InviteUserForm** - User invitation form
- **ProjectCard** - Project display card

## 🔧 Configuration

### Tailwind CSS
The project uses a custom Tailwind configuration in `tailwind.config.js`:

```javascript
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      // Custom theme extensions
    },
  },
  plugins: [
    // Tailwind plugins
  ],
}
```

### Vite Configuration
Build settings are configured in `vite.config.js`:

```javascript
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
})
```

## 🌐 API Integration

### Axios Configuration
The API client is configured in `src/Api/api.js` with:
- Base URL configuration
- Request/Response interceptors
- JWT token handling
- Error handling

### State Management
Redux store is organized by feature:
- **Auth**: User authentication and profile
- **Project**: Project CRUD operations
- **Issue**: Issue management
- **Chat**: Real-time messaging
- **Subscription**: Payment and subscription management

## 🎯 Key Features Implementation

### Authentication Flow
1. User registration/login forms
2. JWT token storage in localStorage
3. Automatic token inclusion in API requests
4. Protected routes with authentication guards

### Project Management
1. Project creation and editing
2. Team member invitation
3. Project dashboard with statistics
4. Project search and filtering

### Issue Tracking
1. Issue creation with rich forms
2. Issue assignment and status updates
3. Comment system for collaboration
4. Issue filtering and sorting

### Real-time Features
1. WebSocket connection for live updates
2. Chat functionality between team members
3. Live notifications for project activities

## 🚀 Deployment

### Build for Production
```bash
npm run build
```

### Deploy to Vercel
```bash
npm install -g vercel
vercel --prod
```

### Deploy to Netlify
```bash
npm run build
# Upload dist/ folder to Netlify
```

### Environment Variables
For production deployment, set these environment variables:
```bash
VITE_API_BASE_URL=https://your-backend-url.com
VITE_APP_ENV=production
```

## 🐛 Troubleshooting

### Common Issues

1. **CORS Errors**
   - Ensure backend CORS configuration includes frontend URL
   - Check API base URL configuration

2. **Build Errors**
   - Clear node_modules and reinstall dependencies
   - Check for TypeScript/ESLint errors

3. **Styling Issues**
   - Rebuild Tailwind CSS
   - Check component import paths

4. **API Connection Issues**
   - Verify backend is running
   - Check network tab in browser dev tools

## 📱 Responsive Design

The application is fully responsive with breakpoints:
- **Mobile**: < 768px
- **Tablet**: 768px - 1024px
- **Desktop**: > 1024px

## 🔮 Future Enhancements

- [ ] Progressive Web App (PWA) features
- [ ] Offline functionality
- [ ] Advanced animations and transitions
- [ ] Accessibility improvements (WCAG compliance)
- [ ] Internationalization (i18n)
- [ ] Component testing with React Testing Library
- [ ] Storybook for component documentation

## 🤝 Contributing

1. Follow the existing code style and conventions
2. Use TypeScript for new components
3. Write tests for new features
4. Update documentation for significant changes
5. Follow the Git commit message convention

## 📞 Support

For frontend-specific issues:
- Check browser console for errors
- Verify API connectivity
- Review component documentation
- Contact: agarwalyash041@gmail.com
