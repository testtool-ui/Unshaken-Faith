# Unshaken Faith

## Overview  
**Unshaken Faith** is an inspirational Android application aimed at delivering smooth user experiences with features like reminders and motivational content. The app showcases clean design principles and a well-structured codebase.

## Features  
- **Elegant Splash Screen**: Displays a logo on a white background for a polished app entry.  
- **Reminders Management**: Create, manage, and display personalized reminders.  
- **Custom Themes**: Adaptable to user preferences with RTL support and dynamic layouts.  
- **Streamlined Build Process**: Optimized for building via GitHub Actions.

## Table of Contents  
1. [Directory Structure](#directory-structure)  
2. [Getting Started](#getting-started)  
3. [Development Workflow](#development-workflow)  
4. [Contributing](#contributing)  
5. [License](#license)

## Directory Structure  
Here’s the project structure for **Unshaken Faith**:  
```
Unshaken Faith/
├── .github/
│   └── workflows/
│       └── build.yml
├── gradle.properties
├── gradlew.bat
├── gradlew
├── settings.gradle
├── build.gradle
├── image.png
├── README.md
├── LICENSE
├── app/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── res/
│           │   ├── mipmap-xxhdpi/
│           │   │   ├── ic_launcher_round.png
│           │   │   └── ic_launcher.png
│           │   ├── mipmap-mdpi/
│           │   │   ├── ic_launcher.png
│           │   │   └── ic_launcher_round.png
│           │   ├── mipmap-hdpi/
│           │   │   ├── ic_launcher_round.png
│           │   │   └── ic_launcher.png
│           │   ├── mipmap-xxxhdpi/
│           │   │   ├── ic_launcher_round.png
│           │   │   └── ic_launcher.png
│           │   ├── mipmap-xhdpi/
│           │   │   ├── ic_launcher_round.png
│           │   │   └── ic_launcher.png
│           │   ├── drawable/
│           │   │   ├── maximus-image.jpg
│           │   │   └── logo.webp
│           │   └── values/
│           │       ├── colors.xml
│           │       └── strings.xml
│           ├── layout/
│           │   ├── activity_splash.xml
│           │   ├── activity_main.xml
│           │   └── fragment_reminder.xml
│           └── java/
│               └── com/
│                   └── mdselim/
│                       └── unshakenfaith/
│                           ├── MainActivity.kt
│                           ├── ReminderAdapter.kt
│                           ├── SplashActivity.kt
│                           ├── ReminderFragment.kt
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties  
```

## Getting Started  

### Prerequisites  
To run the project locally, you need the following installed:  
- **Android Studio** (latest version)  
- **JDK 17 or higher**  
- **Gradle**  

### Clone the Repository  
You can clone the repository using the following command:  

```
git clone https://github.com/your-username/unshaken-faith.git  
```

### Setting up the Project  
1. Open Android Studio.  
2. Select **Open an existing project**.  
3. Navigate to the cloned repository and select the folder.  
4. Sync Gradle and wait for the dependencies to download.

### Building the APK  
Run the following command to build the APK:  

```
./gradlew assembleDebug  
```

## Development Workflow  
We use GitHub Actions to automate the building process. The **build.yml** file located under the `.github/workflows/` directory defines the steps for building the app on each push to the `main` branch.  

### Steps in Build Process:  
1. **Checkout Code**: The code is checked out from the repository.  
2. **Set up JDK**: JDK 17 is installed.  
3. **Cache Gradle**: Gradle dependencies are cached to speed up the build process.  
4. **Build APK**: The APK is built using `./gradlew assembleDebug`.  
5. **Upload Artifact**: The generated APK is uploaded as an artifact for downloading.  

## Contributing  
Contributions are always welcome! Feel free to fork the repository, create a branch, and submit a pull request.  

### Steps for Contribution:  
1. Fork the repository.  
2. Create a new branch from `main`.  
3. Make your changes.  
4. Create a pull request with a description of the changes.  

## License  
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.  
