# 🔢 Base Converter

> **A modern, intuitive Android app for seamless number base conversions between Binary, Octal, Decimal, and Hexadecimal systems**

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com) [![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue.svg)](https://kotlinlang.org) [![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19) [![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

<p align="center">
  <img src="https://user-images.githubusercontent.com/57973837/224551233-c52c59f4-41d1-467e-9572-d9828fa129ce.png" width="30%" alt="Light Mode">
  <img src="https://user-images.githubusercontent.com/57973837/224551229-d86b2124-329b-49c5-9bcd-cdc52929da94.png" width="30%" alt="Dark Mode">
</p>

**Perfect for developers, students, and anyone working with different number systems. Features automatic dark/light mode, clean Material Design UI, and instant conversions.**

[📱 Download APK](releases) • [🎥 Demo Video](#demo) • [📋 Features](#features) • [🚀 Quick Start](#quick-start)

---

## ⚡ Quick Start

### Prerequisites
- **Android Device/Emulator**: API 19+ (Android 4.4 KitKat or higher)
- **Development**: Android Studio Flamingo | 2022.2.1 or newer
- **Java**: JDK 8 or higher

### Installation

#### Option 1: Download APK (Recommended)
```bash
# Download the latest release
wget https://github.com/kariemSeiam/number-converter-app/releases/latest/download/base-converter.apk

# Install on your device
adb install base-converter.apk
```

#### Option 2: Build from Source
```bash
# Clone the repository
git clone https://github.com/kariemSeiam/number-converter-app.git
cd number-converter-app

# Open in Android Studio and build
# Or build using Gradle
./gradlew assembleDebug
```

**✨ That's it! Open the app and start converting numbers instantly.**

---

## 🌟 Features

### Core Capabilities
- **🔢 Multi-Base Conversion** - Convert between Binary (base 2), Octal (base 8), Decimal (base 10), and Hexadecimal (base 16)
- **⚡ Real-time Results** - Instant conversion as you type with input validation
- **🎨 Adaptive Theming** - Automatic dark/light mode following system preferences
- **🔤 Smart Input** - Context-aware number pad with valid digits for selected base
- **🧹 Quick Actions** - Clear and delete buttons for efficient editing

### What Makes This Special
- **Zero Permissions Required** - Complete privacy with no data collection
- **Offline First** - Works without internet connection
- **Material Design 3** - Modern, accessible UI following Google's design guidelines
- **Lightweight** - Small APK size (~2MB) with minimal resource usage
- **Error Handling** - Graceful handling of invalid inputs with helpful feedback

| Feature | Binary | Octal | Decimal | Hexadecimal |
|---------|--------|--------|---------|-------------|
| **Range** | 0-1 | 0-7 | 0-9 | 0-9, A-F |
| **Input Validation** | ✅ | ✅ | ✅ | ✅ |
| **Auto-formatting** | ✅ | ✅ | ✅ | ✅ |

---

## 🎮 Usage Guide

### Basic Conversion
1. **Select Source Base**: Tap the "From" dropdown and choose your input number base
2. **Enter Number**: Type your number using the appropriate digits for the selected base
3. **Select Target Base**: Tap the "To" dropdown and choose your desired output base
4. **Get Result**: Tap "Convert" to see the instant conversion result

### Advanced Tips
- **Quick Switching**: Tap base selectors to quickly change conversion direction
- **Input Validation**: Invalid digits are automatically rejected based on selected base
- **Clear Functions**: Use delete (⌫) to remove last digit or clear (C) to reset completely
- **Copy Results**: Long-press result to copy to clipboard (planned feature)

### Supported Number Ranges
- **Maximum Input**: Up to 2,147,483,647 (32-bit signed integer limit)
- **Negative Numbers**: Currently not supported (positive integers only)
- **Decimal Places**: Not supported (integers only)

---

## 📱 Demo

### Video Demonstration
https://user-images.githubusercontent.com/57973837/224551463-d781dbbd-276e-477b-88b7-01a37efd077d.mp4

*Watch the app in action: seamless conversions between different number bases with real-time results*

### Example Conversions
```
Decimal 255 → Binary: 11111111
Binary 1010 → Decimal: 10
Hexadecimal FF → Octal: 377
Octal 777 → Hexadecimal: 1FF
```

---

## 🏗️ Architecture

### Tech Stack
- **Language**: Kotlin 1.8.20-RC
- **UI Framework**: Android Views with Material Components
- **Minimum SDK**: API 19 (Android 4.4 KitKat)
- **Target SDK**: API 33 (Android 13)
- **Build System**: Gradle 7.4.2

### Project Structure
```
app/
├── src/main/
│   ├── java/com/pigo/baseconverter/
│   │   └── MainActivity.kt           # Main activity with conversion logic
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml     # Main UI layout
│   │   │   └── dropdown_item.xml     # Base selector items
│   │   ├── values/
│   │   │   ├── colors.xml            # Light theme colors
│   │   │   ├── strings.xml           # App strings
│   │   │   └── themes.xml            # Light theme
│   │   ├── values-night/
│   │   │   └── themes.xml            # Dark theme
│   │   └── menu/
│   │       └── menu_conversion_bases.xml
│   └── AndroidManifest.xml
└── build.gradle                     # App-level dependencies
```

### Core Components
- **MainActivity**: Single-activity architecture handling all conversions
- **Base Conversion Engine**: Pure Kotlin implementation using radix conversion
- **Theme System**: Material Design with automatic dark/light mode switching
- **Input Validation**: Real-time validation based on selected number base

### Dependencies
```kotlin
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.core:core-ktx:+'
    implementation 'com.google.android.material:material:1.8.0'
}
```

---

## 🛠️ Development

### Environment Setup
```bash
# Clone the repository
git clone https://github.com/kariemSeiam/number-converter-app.git
cd number-converter-app

# Open in Android Studio
# File → Open → Select project directory

# Or build via command line
./gradlew build
```

### Development Workflow
1. **Code Style**: Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
2. **Testing**: Run unit tests with `./gradlew test`
3. **Build**: Generate debug APK with `./gradlew assembleDebug`
4. **Release**: Create release build with `./gradlew assembleRelease`

### Key Classes
```kotlin
// Main conversion logic
class MainActivity : AppCompatActivity() {
    private fun convertNumber() {
        val fromRadix = getRadixFromBase(fromBase)
        val toRadix = getRadixFromBase(toBase)
        val decimalNumber = inputNumber.toInt(fromRadix)
        val result = decimalNumber.toString(toRadix)
    }
    
    private fun getRadixFromBase(base: String): Int {
        return mapOf(
            "Binary" to 2,
            "Octal" to 8, 
            "Decimal" to 10,
            "Hexadecimal" to 16
        )[base] ?: 0
    }
}
```

### Testing
```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest

# Generate test coverage report
./gradlew createDebugCoverageReport
```

---

## 🚀 Deployment

### Building Release APK
```bash
# Generate release APK
./gradlew assembleRelease

# APK location
ls app/build/outputs/apk/release/
```

### Distribution Options
- **GitHub Releases**: Automated via GitHub Actions
- **Google Play Store**: Not currently published
- **Direct Download**: Available from repository releases

### System Requirements
- **Minimum Android Version**: 4.4 (API 19)
- **Recommended Android Version**: 8.0+ (API 26)
- **Storage**: 10MB available space
- **RAM**: 1GB minimum, 2GB recommended

---

## 📊 Project Status

- **Development Status**: Active maintenance
- **Latest Version**: 1.0 (Initial Release)
- **Compatibility**: Android 4.4+ (API 19-33)
- **Last Updated**: March 2023

### Roadmap
- [ ] **Copy to Clipboard**: Long-press result to copy
- [ ] **History Feature**: Save previous conversions
- [ ] **Negative Numbers**: Support for signed integer conversion
- [ ] **Floating Point**: Decimal number support
- [ ] **Custom Bases**: Support for bases 2-36
- [ ] **Scientific Notation**: Large number handling

---

## 🆘 Support

### Getting Help
- 📖 **Documentation**: This README contains comprehensive usage information
- 🐛 **Bug Reports**: [Create an issue](https://github.com/kariemSeiam/number-converter-app/issues/new?template=bug_report.md)
- 💡 **Feature Requests**: [Request a feature](https://github.com/kariemSeiam/number-converter-app/issues/new?template=feature_request.md)
- 💬 **Questions**: [Start a discussion](https://github.com/kariemSeiam/number-converter-app/discussions)

### Troubleshooting

**App won't install?**
- Ensure "Install from Unknown Sources" is enabled
- Check minimum Android version requirement (4.4+)

**Conversion shows "Invalid input"?**
- Verify input contains only valid digits for selected base
- Ensure number is within supported range (32-bit integer)

**Dark mode not working?**
- Check system dark mode settings
- App follows system theme automatically

---

## 🤝 Contributing

We welcome contributions from the community! Whether it's bug fixes, new features, or documentation improvements.

### How to Contribute
1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/amazing-feature`
3. **Commit** your changes: `git commit -m 'Add amazing feature'`
4. **Push** to the branch: `git push origin feature/amazing-feature`
5. **Submit** a Pull Request

### Development Guidelines
- Follow Kotlin coding conventions
- Add unit tests for new features
- Update documentation as needed
- Ensure compatibility with minimum API level
- Test on both light and dark themes

### Code of Conduct
This project follows the [Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md). Please be respectful and inclusive in all interactions.

---

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2023 Base Converter

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

---

## 🙏 Acknowledgments

- **Material Design**: Google's Material Design system for beautiful UI components
- **Android Community**: Inspiration from open-source Android development practices
- **Contributors**: Thanks to all developers who have contributed to this project
- **Testers**: Community members who provided feedback and bug reports

### Built With ❤️
- **Kotlin**: Modern, concise programming language for Android
- **Material Components**: Google's implementation of Material Design
- **Android Jetpack**: Modern Android development best practices

---

<p align="center">
  <strong>Made with ❤️ for the developer community</strong><br>
  <sub>If you find this project helpful, please ⭐ star it on GitHub!</sub>
</p>
