# sdlc-backend-app
Backend application for SDLC project

## Global Exception Handler

This application includes a comprehensive global exception handler that provides consistent error responses across all endpoints.

### Features

- **Standardized Error Responses**: All errors return a consistent JSON structure with timestamp, status, error type, message, and request path
- **Custom Exceptions**: Pre-defined exception classes for common scenarios:
  - `ResourceNotFoundException`: For 404 Not Found errors
  - `BadRequestException`: For 400 Bad Request errors
  - `DuplicateResourceException`: For 409 Conflict errors
  - `ValidationException`: For custom validation errors
- **Automatic Handling**: Spring validation errors, malformed JSON, type mismatches, and unsupported methods/media types are automatically handled
- **Detailed Error Information**: Validation errors include field-specific details to help clients fix issues
- **Secure Error Logging**: Unexpected errors are logged server-side while returning safe messages to clients

### Error Response Format

```json
{
  "timestamp": "2024-01-30T04:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "User not found with id: '123'",
  "path": "/api/users/123",
  "details": ["Optional array of additional error details"]
}
```

### Usage Example

In your service layer, throw custom exceptions when needed:

```java
public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
}
```

The global exception handler will automatically catch it and return a properly formatted error response to the client.

