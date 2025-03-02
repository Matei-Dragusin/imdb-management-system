# IMDB System Management

## Description

This project implements a management system for a platform similar to IMDB (Internet Movie Database). The application allows users to view, add, and manage information about movies, TV series, and actors, as well as interact with the platform through features such as ratings, requests, and notifications.

## Project Structure

The project is implemented in Java and follows the object-oriented paradigm, using concepts such as:
- Inheritance
- Polymorphism
- Encapsulation
- Interfaces
- Design patterns (Strategy, Factory, Observer, Singleton)
- Generics

### Main Components

#### Users

The system supports three types of users:

1. **Regular** - ordinary users who can view information, add to favorites, rate productions, and submit requests
2. **Contributor** - users who can add and manage content (actors, movies, TV series)
3. **Admin** - users with full platform administration rights

#### Productions

The system manages two types of productions:

1. **Movie** - films with information such as title, directors, actors, genre, ratings, description, duration, and release year
2. **Series** - TV shows with information similar to movies, plus the number of seasons and episodes

#### Actors

Information about actors, including name, biography, and productions they have appeared in.

#### Requests

The system allows users to submit different types of requests:
- **DELETE_ACCOUNT** - account deletion request
- **ACTOR_ISSUE** - problems related to actor information
- **MOVIE_ISSUE** - problems related to movie information
- **OTHERS** - other types of requests

#### Ratings

Users can rate productions with a score between 1 and 10 and can add comments.

## Main Features

### For all users

- Authentication into the system
- Viewing production details (movies and TV series)
- Viewing actor details
- Filtering productions by genre or rating
- Searching for actors, movies, TV series
- Adding/Removing productions and actors to/from favorites list
- Viewing notifications
- Creating and deleting requests
- Rating productions

### For Contributors

- Adding/Removing actors, movies, TV series from the platform
- Resolving requests
- Updating movie, TV series, and actor details

### For Admins

- All features available to Contributors
- Adding/Removing users from the platform
- Managing account deletion requests

## Technical Implementation

The project uses:

- Singleton design pattern for the IMDB class
- Factory pattern for user creation
- Strategy pattern for experience points calculation
- Abstract classes and interfaces for defining common behaviors
- Generics for collection typing
- Collections such as List, SortedSet, Map for data storage

## Application Flow

1. At startup, the application reads data from JSON files (actors, users, productions, requests)
2. The user authenticates into the system
3. Depending on the account type, the user has access to different functionalities
4. The user can navigate through the system using a console-based menu
5. Upon completion of the interaction, the user can log out or close the application

## Data Models

### User

The base class for all users, with information such as:
- Credentials (email, password)
- Personal information (name, country, age, gender, date of birth)
- Account type
- Experience
- Notifications
- Favorites lists

### Production

The base class for all productions, with information such as:
- Title
- Directors
- Actors
- Genres
- Ratings
- Description
- Average rating

### Actor

Information about actors:
- Name
- Biography
- Lists of productions they have appeared in

## File Structure

The project uses three JSON files for data storage:
- **actors.json** - information about actors
- **accounts.json** - information about users
- **production.json** - information about movies and TV series
- **requests.json** - information about user requests

## Design Patterns Used

1. **Singleton** - used for the IMDB class to ensure a single global instance
2. **Factory** - implemented in UserFactory for creating different types of users
3. **Strategy** - used for experience points calculation (ReviewExperienceStrategy, RequestsExperienceStrategy)
4. **Observer** - implemented for the notification system

## Other Features

- Email and password-based authentication
- Notification system for users
- Experience system for users
- Request management system
- Production rating functionality

## How to Use

1. Run the main method in the IMDB class
2. Enter credentials for authentication
3. Navigate through the menu displayed in the console to access various functionalities

## Class Hierarchy Structure

```
User <abstract>
|-- Regular
|-- Staff <abstract>
    |-- Contributor
    |-- Admin

Production <abstract>
|-- Movie
|-- Series

interfaces:
- ExperienceStrategy
- Observer
- RequestsManager
- StaffInterface
- Subject
```
