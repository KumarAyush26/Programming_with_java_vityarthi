# 🎓 Campus Course & Records Manager (CCRM)

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/technologies/downloads/)
[![License](https://img.shields.io/badge/License-Educational-blue.svg)](LICENSE)
[![Build Status](https://img.shields.io/badge/Build-Passing-green.svg)](README.md)

## 📋 Project Description
The **Campus Course & Records Manager (CCRM)** is a comprehensive academic management system developed in Java SE. This system provides a robust, scalable solution for educational institutions to efficiently manage their academic records, course offerings, and student enrollment processes.

### 🌟 Why CCRM?
- **Zero External Dependencies**: Built with pure Java SE for maximum compatibility
- **Educational Focus**: Designed specifically for academic institutions
- **Robust Architecture**: Enterprise-grade design patterns and best practices
- **Comprehensive Validation**: Advanced input validation and error handling
- **Performance Optimized**: Efficient algorithms and data structures

## 🚀 Key Features

### 👥 **Student Management**
- ✅ **Advanced Registration System** with comprehensive validation (regex patterns, email validation)
- 📊 **Academic Profile Management** with complete academic history tracking
- 🎯 **Real-time GPA Calculation** with weighted credit system
- 📈 **Enrollment Status Monitoring** with active/inactive status tracking
- 🔍 **Smart Search & Filtering** by multiple criteria

### 📚 **Course Administration**
- 🏗️ **Dynamic Course Creation** with builder pattern implementation
- 💳 **Flexible Credit System** (1-6 credits per course)
- 🏛️ **Department-wise Organization** with cross-department support
- 📅 **Semester-based Scheduling** (Spring, Summer, Fall)
- 👨‍🏫 **Instructor Assignment** with workload management

### 🎓 **Smart Enrollment System**
- ⚡ **Automated Processing** with business rule validation
- 🚫 **Credit Limit Enforcement** (30 credits standard, 33 for high performers)
- 🔄 **Cross-department Enrollment** support
- ✔️ **Prerequisites Validation** (future enhancement ready)
- 🚨 **Duplicate Prevention** with comprehensive error handling

### 📊 **Advanced Grade Management**
- 🏆 **Flexible Grading Scale** (S=10, A=9, B=8, C=7, D=6, E=5, F=0)
- 🧮 **Weighted GPA Computation** considering credit hours
- 📜 **Professional Transcript Generation** with detailed formatting
- 📈 **Academic Performance Analytics** and tracking
- 📋 **Grade History Management** with audit trail

### 💾 **Robust Data Management**
- 📤 **CSV Import/Export** with error handling and validation
- 🔄 **Automated Backup Systems** with timestamp management
- ✅ **Advanced Data Validation** with custom error messages
- 📁 **File Operation Utilities** with NIO.2 for better performance
- 🗃️ **Data Integrity Checks** throughout the system

## 🏗️ Technical Architecture

### **Core Technologies**
- ☕ **Pure Java SE 17+** (zero external dependencies)
- 🔧 **Object-Oriented Design** with complete inheritance hierarchy
- 🔌 **Interface-based Service Architecture** for modularity
- 🛡️ **Comprehensive Error Handling** with custom exceptions
- 📂 **Modern File I/O** using NIO.2 for optimal performance
- 🌊 **Stream API Integration** for efficient data processing

### **Design Patterns Implemented**
- 🏭 **Builder Pattern** (CourseBuilder)
- 🔍 **Strategy Pattern** (Comparators)
- 📋 **Template Method** (Error handling)
- 🎯 **Singleton Pattern** (Configuration management)
- 🔄 **Observer Pattern** (Ready for future enhancements)

### **Performance Optimizations**
- 📊 **Pre-compiled Regex Patterns** for validation
- 🗂️ **Static Comparator Instances** to reduce object creation
- 💾 **Efficient Memory Management** with proper resource handling
- ⚡ **Stream-based Operations** for large data processing
- 🔄 **Lazy Loading** where applicable

## 📖 Business Rules & Policies

### **📚 Credit System**
- 🎯 **Standard Limit**: 30 credits per semester
- 🌟 **High Performer Bonus**: 33 credits (GPA ≥ 8.5)
- 📝 **Minimum Requirement**: 12 credits for first enrollment
- ⚖️ **Credit Range**: 1-6 credits per course

### **🎓 Grading System**
- 🏆 **Grade Scale**: S(10), A(9), B(8), C(7), D(6), E(5), F(0)
- 📊 **GPA Calculation**: Weighted by credit hours
- 📈 **Performance Tracking**: Complete academic history
- ✅ **Grade Validation**: 0-100 marks range

### **🏛️ Administrative Policies**
- 🔐 **Department Restrictions**: Configurable course access
- 👨‍🏫 **Instructor Workload**: Managed assignment limits
- 📅 **Semester Management**: Spring, Summer, Fall scheduling
- 🚫 **Duplicate Prevention**: Enrollment and data integrity

## 🚀 Quick Start Guide

### **📋 Prerequisites**
- ☕ **Java Development Kit (JDK) 17+** - [Download here](https://adoptium.net/)
- 💻 **Command Line Terminal** (PowerShell, CMD, or Bash)
- 📁 **1GB+ Free Disk Space** for data and backups
- 🔧 **Text Editor/IDE** (VS Code, IntelliJ, Eclipse - optional)

### **⚡ Quick Setup & Run**

```bash
# 1. Clone/Download the project
cd Programming-in-Java---Project-1-main

# 2. Create output directory
mkdir bin

# 3. Compile all sources (one command)
javac -d bin -cp src src/edu/ccrm/**/*.java

# 4. Run the application
java -cp bin edu.ccrm.cli.Main

# 5. Run with assertions enabled (recommended for development)
java -ea -cp bin edu.ccrm.cli.Main
```

### **🎯 Alternative Compilation Methods**

```bash
# Method 1: Compile specific entry point (simpler)
javac -d bin -cp src src/edu/ccrm/cli/Main.java

# Method 2: Compile with verbose output (debugging)
javac -d bin -cp src -verbose src/edu/ccrm/**/*.java

# Method 3: Compile with all lint warnings
javac -d bin -cp src -Xlint:all src/edu/ccrm/**/*.java
```

### **🔧 Development Setup**

```bash
# Enable assertions for testing
java -ea -cp bin edu.ccrm.cli.Main

# Run with logging enabled
java -Djava.util.logging.config.file=logging.properties -cp bin edu.ccrm.cli.Main

# Run with increased memory (for large datasets)
java -Xmx1G -cp bin edu.ccrm.cli.Main
```

## Evolution of Java (Timeline)
- 1995: Java 1.0 released (write once, run anywhere)
- 1998: Java 2 split into J2SE, J2EE, J2ME
- 2004: Java 5 (Generics, Enums, Annotations, enhanced for-loop)
- 2011: Java 7 (try-with-resources, NIO.2)
- 2014: Java 8 (Lambdas, Streams, Date/Time API)
- 2017: Java 9 (Modules, JShell) and 6-month release cadence begins
- 2021: Java 17 LTS (long-term support)
- 2023+: Java 21 LTS, ongoing LTS every ~3 years

## Java Editions Comparison

| Feature           | Java ME (Micro)     | Java SE (Standard)    | Java EE (Enterprise)   |
|------------------|--------------------|--------------------|---------------------|
| Purpose          | Mobile/Embedded    | Desktop/Server     | Large Enterprise    |
| Memory Footprint | Minimal (<512KB)   | Medium (100MB+)    | Large (500MB+)      |
| APIs             | Limited subset     | Core platform      | Enterprise features |
| Use Cases        | IoT, Smart cards   | Applications       | Web/Cloud apps      |
| Deployment       | Embedded devices   | Standalone         | App servers         |
| Key Features     | CLDC, MIDP        | Collections, NIO   | JPA, EJB, JSP      |
| Development      | Resource-conscious | General purpose    | Distributed systems |

## Java Architecture (JDK/JRE/JVM)

### Components Overview
1. JDK (Java Development Kit)
   - Development tools (javac, jar)
   - Debugger (jdb)
   - Documentation generator (javadoc)
   - Contains JRE

2. JRE (Java Runtime Environment)
   - Java class libraries
   - Runtime components
   - Contains JVM

3. JVM (Java Virtual Machine)
   - Bytecode execution engine
   - Memory management/GC
   - Platform independence
   - Security sandbox

### Component Interaction Flow
```plaintext
Source Code (.java)
      ↓
    JDK (javac)
      ↓
Bytecode (.class)
      ↓
    JRE
      ↓
    JVM
      ↓
Native Machine Code
```

## 📁 Project Structure

```
Programming-in-Java---Project-1-main/
├── 📂 src/                          # Source code directory
│   └── 📂 edu/ccrm/                 # Main package
│       ├── 📂 cli/                  # Command Line Interface
│       │   └── Main.java            # Application entry point
│       ├── 📂 config/               # Configuration management
│       │   ├── AppConfig.java       # Application settings
│       │   └── EnrollmentConfig.java # Enrollment policies
│       ├── 📂 domain/               # Core business entities
│       │   ├── Person.java          # Abstract base class
│       │   ├── Student.java         # Student entity
│       │   ├── Course.java          # Course entity
│       │   ├── Instructor.java      # Instructor entity
│       │   ├── Enrollment.java      # Enrollment relationship
│       │   ├── Grade.java           # Grade enumeration
│       │   └── *Exception.java      # Custom exceptions
│       ├── 📂 service/              # Business logic layer
│       │   ├── *Service.java        # Service interfaces
│       │   └── *ServiceImpl.java    # Service implementations
│       ├── 📂 util/                 # Utility classes
│       │   ├── Validator.java       # Input validation
│       │   ├── *Comparator.java     # Sorting utilities
│       │   ├── ErrorHandler.java    # Error management
│       │   └── RecursionUtils.java  # File operations
│       └── 📂 io/                   # Input/Output operations
│           ├── ImportExportService.java # Data I/O interface
│           └── BackupService.java   # Backup utilities
├── 📂 bin/                          # Compiled classes (auto-generated)
├── 📂 test-data/                    # Sample data files
│   ├── students.csv                 # Sample student data
│   ├── courses.csv                  # Sample course data
│   └── *.csv                        # Other test files
├── 📂 screenshots/                  # Application screenshots
├── 📄 README.md                     # This file
├── 📄 USAGE.md                      # User guide
├── 📄 requirements.md               # Setup requirements
└── 📄 DISCLOSURE.md                 # Academic integrity
```

## 🛠️ Installation & Setup Guide

### **Windows Installation (Recommended)**

#### **Step 1: Install Java JDK**
```powershell
# Option 1: Download from official sources
# Visit: https://adoptium.net/ (recommended) or https://oracle.com/java/
# Download: OpenJDK 17+ Windows x64 installer

# Option 2: Using Chocolatey (if installed)
choco install openjdk17

# Option 3: Using Scoop (if installed)
scoop install openjdk17
```

#### **Step 2: Verify Installation**
```powershell
java -version        # Should show 17.x.x or higher
javac -version       # Should match java version
echo $env:JAVA_HOME  # Should show JDK path
```

#### **Step 3: Set Environment Variables (if needed)**
```powershell
# Set JAVA_HOME (replace path as needed)
[System.Environment]::SetEnvironmentVariable('JAVA_HOME', 'C:\Program Files\Eclipse Adoptium\jdk-17.0.x-hotspot', 'Machine')

# Add to PATH
$currentPath = [System.Environment]::GetEnvironmentVariable('PATH', 'Machine')
[System.Environment]::SetEnvironmentVariable('PATH', "$currentPath;%JAVA_HOME%\bin", 'Machine')
```

### **Linux/macOS Installation**

#### **Ubuntu/Debian:**
```bash
sudo apt update
sudo apt install openjdk-17-jdk
java -version && javac -version
```

#### **macOS (Homebrew):**
```bash
brew install openjdk@17
java -version && javac -version
```

### **IDE Setup (Optional but Recommended)**

#### **VS Code Setup:**
```bash
# Install Java Extension Pack
# 1. Open VS Code
# 2. Go to Extensions (Ctrl+Shift+X)
# 3. Search "Extension Pack for Java"
# 4. Install the pack by Microsoft
```

#### **IntelliJ IDEA Setup:**
```bash
# 1. Download IntelliJ IDEA Community (free)
# 2. File → New → Project from Existing Sources
# 3. Select the project root directory
# 4. Choose "Import project from external model" → None
# 5. Set Project SDK to JDK 17+
```

## 🎯 Java Concepts Implementation Map

| 📚 **Concept** | 📍 **Implementation** | 📝 **Description** | 🔗 **Advanced Usage** |
|----------------|----------------------|-------------------|---------------------|
| **🔒 Encapsulation** | `domain/Person.java` | Private fields with getters/setters | Data hiding with validation |
| **🧬 Inheritance** | `domain/Student.java` | Extends Person class | Multi-level inheritance hierarchy |
| **🎭 Abstraction** | `domain/Person.java` | Abstract base class with abstract methods | Template method pattern |
| **🎪 Polymorphism** | `service/*Service` | Interface implementations | Runtime method binding |
| **🔌 Interfaces** | `service/CourseService.java` | Service contracts | Multiple interface implementation |
| **📦 Collections** | `domain/Student.java` | `ArrayList` for enrolledCourses | Advanced collection operations |
| **🔄 Generics** | `service/ImportExportService.java` | Generic type parameters | Type safety and reusability |
| **⚠️ Exception Handling** | `domain/*Exception.java` | Custom exceptions | Comprehensive error management |
| **🌊 Stream API** | `service/CourseServiceImpl.java` | Filtering and searching | Complex data transformations |
| **📅 Date/Time API** | `domain/Student.java` | Enrollment dates | Modern temporal operations |
| **📁 File I/O (NIO.2)** | `io/BackupService.java` | Advanced file operations | Efficient file handling |
| **🏗️ Builder Pattern** | `domain/CourseBuilder.java` | Fluent object construction | Complex object creation |
| **🔄 Recursion** | `util/RecursionUtils.java` | Directory traversal | Tree-like data processing |
| **📊 Comparators** | `util/*Comparator.java` | Advanced sorting | Multi-criteria comparisons |
| **✅ Assertions** | Throughout codebase | Development-time validation | Runtime verification |
| **🔍 Regex Patterns** | `util/Validator.java` | Input validation | Pre-compiled patterns |
| **🎯 Enums** | `domain/Grade.java`, `domain/Semester.java` | Type-safe constants | Behavior-rich enumerations |
| **📝 Annotations** | `@Override`, `@SuppressWarnings` | Metadata and compiler hints | Code documentation |
| **🧵 Functional Interfaces** | `util/JavaFeatureDemo.java` | Lambda expressions | Modern functional programming |

## Using Assertions
Enable assertions when running:
```bash
java -ea -cp bin edu.ccrm.cli.Main
```

Key assertion points in code:
```java
// Student.java
assert regNo.matches("^[A-Z]{2}\\d{6}$") : "Invalid registration number format";

// Course.java
assert credits > 0 && credits <= 6 : "Credits must be between 1 and 6";

// EnrollmentService.java
assert !isMaxCreditLimitExceeded() : "Maximum credit limit exceeded";
```

## Java ME vs SE vs EE
| Category       | Java ME (Micro Edition)              | Java SE (Standard Edition)                 | Java EE (Enterprise Edition)                          |
|----------------|--------------------------------------|--------------------------------------------|------------------------------------------------------|
| Target         | Mobile/embedded/IoT devices          | Desktop apps, command-line tools, servers  | Large-scale enterprise/web apps, microservices       |
| APIs           | Subset of SE, device-constrained APIs| Full core libraries (collections, streams) | SE + enterprise APIs (Servlets, JPA, EJB, JAX-RS)    |
| Runtime        | CLDC/CDC profiles                     | JRE (JVM + core libs)                      | Application server (e.g., GlassFish, WildFly, Payara)|
| Packaging      | MIDlets                                | JARs                                        | WAR/EAR (web/enterprise archives)                    |
| Examples       | Feature phones, sensors, set-top boxes| CLI tools, Swing/JavaFX apps, services     | Web apps, REST APIs, message-driven apps             |
| Status         | Legacy/limited adoption today         | Mainstream                                  | Evolved into Jakarta EE (under Eclipse Foundation)   |

## Java Architecture
- JDK (Java Development Kit)
  - What: Developer toolkit that includes the JRE, compiler (javac), debugger, and build tools.
  - Use: You install the JDK to compile and build Java programs.
- JRE (Java Runtime Environment)
  - What: Runtime that includes the JVM plus the standard libraries needed to run Java apps.
  - Use: End-users need the JRE to run Java apps (JRE is bundled inside the JDK).
- JVM (Java Virtual Machine)
  - What: The virtual machine that executes Java bytecode (.class files) on your OS/CPU.
  - Use: Provides portability, memory management (GC), JIT compilation.

How they interact:
- You write .java source files -> JDK compiles to .class bytecode -> JVM executes bytecode using JRE libraries.
- Diagram (conceptual): JDK = JRE + tools; JRE = JVM + core libraries.

## Install & Configure Java on Windows (Step-by-step)
1) Download the JDK
- Recommended: [Adoptium Temurin](https://adoptium.net) (LTS) or [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
- Choose the Windows x64 MSI installer.

2) Install
- Run the installer and follow defaults. If offered, select "Set JAVA_HOME" and "Add to PATH".
- Otherwise, set them manually after installation (see below).

3) Set environment variables (if not set by installer)
- JAVA_HOME: points to your JDK install directory (e.g., C:\Program Files\Java\jdk-17)
- PATH: should include %JAVA_HOME%\bin

Using UI (System Properties):
- Start > "Environment Variables" > Edit system variables
- New System Variable: JAVA_HOME = C:\Program Files\Java\jdk-17
- Edit PATH > Add: %JAVA_HOME%\bin

Using PowerShell (Admin):
```powershell path=null start=null
[System.Environment]::SetEnvironmentVariable('JAVA_HOME','C:\\Program Files\\Java\\jdk-17','Machine')
$envPath = [System.Environment]::GetEnvironmentVariable('Path','Machine')
[System.Environment]::SetEnvironmentVariable('Path',"$envPath;%JAVA_HOME%\\bin",'Machine')
```

4) Verify installation
```powershell path=null start=null
java -version
javac -version
```
Expected output shows the installed versions.

Screenshots (replace with your own):
- screenshots/java-install-download.png
- screenshots/java-install-env-vars.png
- screenshots/java-install-verify.png

## Using Eclipse IDE (Project & Run Config)
1) Install Eclipse IDE for Java Developers
- Download from https://www.eclipse.org/downloads/
- Run installer and choose "Eclipse IDE for Java Developers".

2) Create a new Java Project
- File > New > Java Project
- Project name: CCRM (or your choice)
- JRE: Use installed JDK (JavaSE-17 or higher)
- Finish

3) Add source folders and packages
- Right-click project > New > Source Folder: src
- Create packages: edu.ccrm.cli, edu.ccrm.domain, edu.ccrm.service, etc.
- Add existing files under src/ accordingly.

4) Create/run Main class
- File > New > Class > Name: Main, Package: edu.ccrm.cli
- Ensure it has public static void main(String[] args)
- Right-click Main.java > Run As > Java Application

5) Configure Run Configuration (optional)
- Run > Run Configurations...
- Java Application > Main (or your class)
- Classpath: ensure project bin/ (or Eclipse auto builds) is present
- Arguments: set Program Arguments if needed
- Apply > Run

Screenshots (replace with your own):
- screenshots/eclipse-new-project.png
- screenshots/eclipse-package-structure.png
- screenshots/eclipse-run-config.png

## Syllabus Mapping Table
| Topic                        | File/Class/Method                |
|------------------------------|----------------------------------|
| Encapsulation                | domain/Person, Student           |
| Inheritance                  | domain/Person, Student, Instructor|
| Abstraction                  | domain/Person (abstract)         |
| Polymorphism                 | TranscriptService, toString()    |
| Access Levels                | All domain classes               |
| Immutability                 | domain/CourseCode, Name          |
| Nested Classes               | CourseBuilder, RecursionUtils    |
| Interfaces                   | service/*Service, util/Searchable|
| Lambdas/Streams              | CourseServiceImpl, CLI           |
| Enums                        | domain/Semester, Grade           |
| Upcast/Downcast              | Comments in EnrollmentService    |
| Overriding/Overloading       | domain/*, TranscriptService      |
| Singleton                    | config/AppConfig                 |
| Builder                      | domain/CourseBuilder             |
| Exceptions                   | domain/*Exception, try/catch     |
| NIO.2/File I/O               | io/*, BackupService              |
| Date/Time API                | domain/Person, Enrollment        |
| Recursion                    | util/RecursionUtils              |

## Enabling Assertions
- Run with: `java -ea -cp bin edu.ccrm.cli.Main`

## Sample Commands & Data Files
- See `test-data/` for sample CSVs
- Import: `import students.csv`
- Export: `export all.csv`

## 🧪 Testing & Quality Assurance

### **Unit Testing**
```bash
# Run with assertions enabled for comprehensive testing
java -ea -cp bin edu.ccrm.cli.Main

# Test with sample data
java -cp bin edu.ccrm.cli.Main < test-data/students.csv
```

### **Performance Testing**
```bash
# Run with increased memory for large datasets
java -Xmx2G -cp bin edu.ccrm.cli.Main

# Enable verbose garbage collection
java -Xloggc:gc.log -XX:+PrintGC -cp bin edu.ccrm.cli.Main
```

### **Code Quality Checks**
```bash
# Compile with all lint warnings
javac -Xlint:all -d bin src/edu/ccrm/**/*.java

# Generate documentation
javadoc -d docs -sourcepath src -subpackages edu.ccrm
```

## 🚀 Advanced Usage Examples

### **Sample Data Import**
```bash
# Import student data
java -cp bin edu.ccrm.cli.Main
# Select option 4 (Import/Export Data)
# Choose option a (Import)
# Enter path: test-data/students.csv
```

### **Batch Operations**
```bash
# Create comprehensive test scenario
java -cp bin edu.ccrm.cli.Main
# 1. Import students and courses
# 2. Enroll students in courses
# 3. Record grades
# 4. Generate transcripts
# 5. Export all data for backup
```

## 🤝 Contributing Guidelines

### **Code Style**
- ✅ Follow Java naming conventions
- ✅ Use meaningful variable and method names
- ✅ Add JavaDoc for public methods
- ✅ Maintain consistent indentation (4 spaces)
- ✅ Keep line length under 120 characters

### **Commit Messages**
```bash
# Format: <type>(<scope>): <description>
git commit -m "feat(util): add advanced validation methods"
git commit -m "fix(service): resolve enrollment credit calculation bug"
git commit -m "docs(readme): update installation instructions"
```

## 📚 Educational Resources

### **Learning Objectives Covered**
- ✅ **OOP Principles**: Encapsulation, Inheritance, Abstraction, Polymorphism
- ✅ **Advanced Java**: Generics, Collections, Stream API, Lambda Expressions
- ✅ **Design Patterns**: Builder, Strategy, Template Method, Singleton
- ✅ **Error Handling**: Custom exceptions, validation, logging
- ✅ **File Operations**: NIO.2, CSV processing, backup systems
- ✅ **Testing**: Assertions, unit testing concepts, validation

### **Further Reading**
- 📖 [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- 📖 [Effective Java by Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- 📖 [Java: The Complete Reference](https://www.oracle.com/java/technologies/javase-documentation.html)
- 📖 [Clean Code by Robert Martin](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)

## 🐛 Troubleshooting

### **Common Issues**

#### **"Class not found" Error**
```bash
# Ensure proper classpath
java -cp bin edu.ccrm.cli.Main

# Verify compilation
javac -d bin src/edu/ccrm/cli/Main.java
```

#### **"Package does not exist" Error**
```bash
# Ensure package structure matches directory structure
# Compile from project root
javac -d bin -cp src src/edu/ccrm/**/*.java
```

#### **Memory Issues**
```bash
# Increase heap size
java -Xmx1G -cp bin edu.ccrm.cli.Main

# Monitor memory usage
java -XX:+PrintGCDetails -cp bin edu.ccrm.cli.Main
```

### **Getting Help**
- 📧 Check `USAGE.md` for detailed usage instructions
- 📧 Review `requirements.md` for setup requirements
- 📧 Examine `test-data/README.md` for sample data formats
- 📧 Enable assertions (`-ea`) for better error messages

## 📄 License & Academic Integrity

### **Educational Use**
This project is developed for educational purposes as part of academic coursework. It demonstrates comprehensive Java programming concepts and best practices.

### **Academic Integrity Statement**
- ✅ All code is original and developed for learning purposes
- ✅ External resources and references are properly documented
- ✅ No plagiarism or unauthorized collaboration
- ✅ Complies with institutional academic integrity policies

### **Usage Rights**
- ✅ **Educational Use**: Free to use for learning and teaching
- ✅ **Modification**: Allowed for educational enhancement
- ✅ **Distribution**: Permitted with proper attribution
- ❌ **Commercial Use**: Not permitted without explicit permission

---

<div align="center">

### 🎓 **Campus Course & Records Manager (CCRM)**
**Empowering Educational Excellence Through Technology**

[![Made with Java](https://img.shields.io/badge/Made%20with-Java-red.svg)](https://www.oracle.com/java/)
[![Educational Project](https://img.shields.io/badge/Project-Educational-blue.svg)](README.md)
[![Version](https://img.shields.io/badge/Version-1.0.0-green.svg)](README.md)

**[📚 Documentation](USAGE.md) • [⚙️ Setup Guide](requirements.md) • [🧪 Test Data](test-data/README.md)**

</div>

---

**© 2025 CCRM Project. Educational use only. All rights reserved.** 
