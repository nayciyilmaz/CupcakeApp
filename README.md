![Logo](https://github.com/nayciyilmaz/CupcakeApp/blob/main/e1.jpg?raw=true)

## Features

- **Modern UI Design**: Utilizes Material3 components to create a modern and user-friendly interface.
- **Order Summary**: Users can view a summary of their order including the quantity, flavor, pickup date, and total price.
- **Share Functionality**: The ability to share the order details with other applications through the share intent.
- **Responsive State Management**: Uses `StateFlow` to manage and react to state changes in the order process (e.g., quantity, flavor, date, price).
- **Order Reset**: Provides the functionality to reset the order and navigate back to the start screen.
- **Dynamic Price Calculation**: Calculates the total price dynamically based on the selected quantity and whether it is a same-day order or not.

## Project Structure

- `MainActivity.kt`: The entry point of the app where the initial UI setup and navigation are defined.
- `SummaryScreen()`: The screen that displays the summary of the order including quantity, flavor, pickup date, and price. Users can share or reset the order from this screen.
- `OrderViewModel`: Contains the logic for managing the order state, including quantity, flavor, price, and date, as well as calculating the total price and formatting it.
- `OrderData`: A data class that holds the state of the order (quantity, price, flavor, date, etc.).
- `EditTopAppBar()`: A custom TopAppBar component for the app’s header that includes the title and back navigation functionality.
- `CupcakeScreens`: Contains the navigation routes for different screens of the app, like starting the order or viewing the summary.

## Technologies Used

- **Kotlin**: The primary programming language used for Android development.
- **Jetpack Compose**: A modern toolkit for building native Android UIs using a declarative approach.
- **Material Design 3**: For implementing UI components that follow Material Design principles.
- **Kotlin Coroutines & StateFlow**: For managing reactive state changes in the application.
- **Intent API**: For sharing the order summary with other apps.
- **Date Formatting**: Used `SimpleDateFormat` to handle and display dates in a localized format.
