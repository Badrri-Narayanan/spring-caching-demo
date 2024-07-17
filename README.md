# Spring Caching with Example Endpoints

This document showcases Spring Caching implementation using various API endpoints for countries and cities.

## Endpoints (Illustrative)

- **GET /country** - Retrieves a country by its code. (Cacheable)
- **GET /country/visit** - Marks a country as visited. (Not Cacheable)
- **GET /country/capital** - Retrieves the capital city of a country by code. (Cacheable)
- **GET /countries** - Retrieves all countries. (Cacheable with configurable expiration)
- **GET /countries/fetch-visited** - Retrieves all visited countries. (Cacheable)
- **GET /cities** - Retrieves all cities. (Consider caching based on usage)
- **GET /cities/country** - Retrieves cities for a specific country. (Cacheable with conditional logic)

## Spring Caching Benefits

- Improved application performance by reducing database load for frequently accessed data.
- Enhanced user experience with faster response times.

## Implementation Details

- Specific annotations (e.g., `@Cacheable`, `@CachePut`, `@CacheEvict`) will be used on controller methods to enable caching.
- Cache configuration (e.g., cache name, expiration time) will be defined in the Spring application context.

## Note

This is a high-level overview. Specific caching strategies (e.g., cache invalidation for updates) will be tailored to each endpoint's functionality.
