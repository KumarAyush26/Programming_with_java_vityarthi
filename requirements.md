# 🛠️ CCRM Project Requirements & Setup Guide

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://adoptium.net/)
[![Platform](https://img.shields.io/badge/Platform-Cross--Platform-lightgrey.svg)](README.md)
[![Setup Time](https://img.shields.io/badge/Setup%20Time-5%20minutes-green.svg)](requirements.md)

## 📋 System Requirements

### **🔧 Essential Requirements**
| Component | Requirement | Recommended | Notes |
|-----------|-------------|-------------|-------|
| **☕ Java JDK** | 17+ | **OpenJDK 21 LTS** | [Download from Adoptium](https://adoptium.net/) |
| **💾 Disk Space** | 500MB | **2GB+** | For IDE, docs, and data |
| **🧠 Memory (RAM)** | 2GB | **8GB+** | For development and IDE |
| **💻 Operating System** | Any | **Windows 10+/Ubuntu 20+/macOS 12+** | Cross-platform support |
| **🖥️ Terminal** | Any CLI | **PowerShell 7+/Bash** | Command execution |

### **🎯 Optional but Recommended**
- 🔧 **IDE**: VS Code, IntelliJ IDEA, or Eclipse
- 📝 **Text Editor**: Notepad++, Sublime Text, or Vim
- 🔄 **Version Control**: Git for source management
- 📊 **Documentation**: Web browser for viewing docs

## 🚀 Environment Setup Guide

### **Step 1: 🔍 Verify Current Java Installation**

```bash
# Check Java version (should be 17+)
java -version

# Check compiler version (should match runtime)
javac -version

# Check JAVA_HOME environment variable
echo $JAVA_HOME    # Linux/macOS
echo %JAVA_HOME%   # Windows CMD
echo $env:JAVA_HOME # PowerShell
```

**Expected Output:**
```
openjdk version "17.0.x" 2023-xx-xx
OpenJDK Runtime Environment (build 17.0.x+xx)
```

### **Step 2: 📁 Project Structure Validation**

**🔴 CRITICAL**: Maintain this EXACT structure for automated evaluation:

```
📁 Programming-in-Java---Project-1-main/
├── 📂 src/                               # Source code (DO NOT MODIFY STRUCTURE)
│   └── 📂 edu/ccrm/                      # Main package
│       ├── 📂 cli/                       # Entry point
│       │   └── Main.java                 # Application launcher
│       ├── 📂 config/                    # Configuration classes
│       │   ├── AppConfig.java
│       │   └── EnrollmentConfig.java
│       ├── 📂 domain/                    # Business entities
│       │   ├── *.java                    # Core domain classes
│       │   └── *Exception.java           # Custom exceptions
│       ├── 📂 service/                   # Business logic
│       │   ├── *Service.java             # Interfaces
│       │   └── *ServiceImpl.java         # Implementations
│       ├── 📂 util/                      # Utility classes
│       │   ├── Validator.java
│       │   ├── *Comparator.java
│       │   └── *.java
│       └── 📂 io/                        # Input/Output operations
│           ├── ImportExportService.java
│           └── BackupService.java
├── 📂 bin/                               # Compiled classes (auto-generated)
├── 📂 test-data/                         # Sample CSV files
│   ├── students.csv
│   ├── courses.csv
│   ├── enrollments.csv
│   └── *.csv
├── 📂 screenshots/                       # Application screenshots
├── 📄 README.md                          # Project documentation
├── 📄 USAGE.md                           # Usage instructions
├── 📄 requirements.md                    # This file
├── 📄 DISCLOSURE.md                      # Academic integrity
├── 📄 TestRegex.java                     # Regex testing utility
└── 📄 TestRegex2.java                    # Advanced regex tests
```

### **Step 3: 🔨 Compilation Methods**

#### **Method 1: Quick Compilation (Recommended)**
```bash
# Navigate to project root
cd Programming-in-Java---Project-1-main

# Create output directory
mkdir bin

# Compile everything at once
javac -d bin -cp src src/edu/ccrm/**/*.java
```

#### **Method 2: Entry Point Compilation**
```bash
# Compile from main class (auto-resolves dependencies)
javac -d bin -cp src src/edu/ccrm/cli/Main.java
```

#### **Method 3: Development Compilation (Verbose)**
```bash
# With detailed output for debugging
javac -d bin -cp src -verbose -Xlint:all src/edu/ccrm/**/*.java
```

#### **Method 4: Cross-Platform Script**

**Windows (PowerShell):**
```powershell
# Create and run compile.ps1
$sourceDir = "src"
$outputDir = "bin"
if (!(Test-Path $outputDir)) { New-Item -ItemType Directory -Path $outputDir }
javac -d $outputDir -cp $sourceDir (Get-ChildItem -Path "$sourceDir\edu\ccrm" -Filter "*.java" -Recurse).FullName
```

**Linux/macOS (Bash):**
```bash
#!/bin/bash
# Create and run compile.sh
SOURCE_DIR="src"
OUTPUT_DIR="bin"
mkdir -p $OUTPUT_DIR
find $SOURCE_DIR -name "*.java" | xargs javac -d $OUTPUT_DIR -cp $SOURCE_DIR
```

### **Step 4: ▶️ Execution Options**

#### **Standard Execution**
```bash
# Basic run
java -cp bin edu.ccrm.cli.Main
```

#### **Development Mode (Recommended)**
```bash
# With assertions enabled for validation
java -ea -cp bin edu.ccrm.cli.Main
```

#### **Production Mode**
```bash
# With optimized settings
java -server -Xmx1G -cp bin edu.ccrm.cli.Main
```

#### **Debug Mode**
```bash
# With detailed logging
java -ea -Djava.util.logging.config.file=logging.properties -cp bin edu.ccrm.cli.Main
```

# Run with assertions enabled (recommended for testing)
java -ea -cp bin edu.ccrm.cli.Main
```

## 🚨 Critical Requirements for Automated Evaluation

### **📏 Code Standards & Structure**

#### **1. 📝 File Naming Convention**
```bash
✅ CORRECT: Student.java, CourseService.java, Main.java
❌ INCORRECT: student.java, courseservice.java, main.java
```
- **Case Sensitivity**: Strictly enforced
- **Class-File Matching**: File name MUST match public class name exactly
- **No Special Characters**: Only alphanumeric and underscores

#### **2. 🏗️ Package & Class Structure**
```java
// ✅ MAINTAIN EXACT PACKAGE DECLARATIONS
package edu.ccrm.domain;
public class Student extends Person { /* ... */ }

// ✅ PRESERVE INTERFACE SIGNATURES
public interface CourseService {
    void addCourse(Course course);
    List<Course> listCourses();
    // DO NOT MODIFY EXISTING METHODS
}
```

#### **3. 📊 Data Format Compliance**
```csv
# ✅ students.csv format (DO NOT MODIFY)
id,regNo,fullName,email
STU001,CS123456,John Doe,john@university.edu

# ✅ courses.csv format (DO NOT MODIFY)
code,title,credits,instructor,semester,department
CS101,Programming,3,,FALL,Computer Science
```

### **🔧 Build & Runtime Requirements**

#### **4. 🚫 Dependency Restrictions**
```java
// ✅ ALLOWED - Java SE only
import java.util.*;
import java.nio.file.*;
import java.time.*;

// ❌ FORBIDDEN - External libraries
import com.google.gson.*;
import org.apache.commons.*;
import org.springframework.*;
```

#### **5. 📤 Console Output Standards**
```bash
# ✅ EXACT FORMAT REQUIRED
=== Campus Course & Records Manager (CCRM) ===
1. Manage Students
2. Manage Courses
[...exact menu structure as specified...]

# ❌ FORBIDDEN - Additional debug output
System.out.println("Debug: Processing student data...");
```

## 🔍 Troubleshooting Guide

### **⚠️ Common Compilation Issues**

#### **Issue 1: "Package does not exist"**
```bash
# 🔴 Error: package edu.ccrm.domain does not exist

# ✅ Solution 1: Check directory structure
ls -la src/edu/ccrm/  # Should show: cli/ config/ domain/ io/ service/ util/

# ✅ Solution 2: Verify package declarations
grep -r "package edu.ccrm" src/  # All should match directory structure

# ✅ Solution 3: Clean compilation
rm -rf bin/
mkdir bin
javac -d bin -cp src src/edu/ccrm/**/*.java
```

#### **Issue 2: "Class not found" at runtime**
```bash
# 🔴 Error: Could not find or load main class edu.ccrm.cli.Main

# ✅ Solution 1: Verify classpath
java -cp "bin" edu.ccrm.cli.Main  # Use quotes on Windows

# ✅ Solution 2: Check compiled classes
ls -la bin/edu/ccrm/cli/  # Should contain Main.class

# ✅ Solution 3: Full recompilation
javac -d bin -cp src src/edu/ccrm/cli/Main.java
```

#### **Issue 3: Character encoding problems**
```bash
# 🔴 Error: Unmappable character for encoding

# ✅ Solution: Specify UTF-8 encoding
javac -encoding UTF-8 -d bin -cp src src/edu/ccrm/**/*.java
```

### **🔧 Platform-Specific Issues**

#### **Windows PowerShell:**
```powershell
# Issue: Path separator problems
javac -d bin -cp "src" src\edu\ccrm\**\*.java  # Use backslashes
java -cp "bin" edu.ccrm.cli.Main               # Use quotes

# Issue: Execution policy
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

#### **Linux/macOS Terminal:**
```bash
# Issue: Permission denied
chmod +x compile.sh
./compile.sh

# Issue: Java not in PATH
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

## 🧪 Validation & Testing

### **📋 Pre-Submission Checklist**

#### **✅ Code Quality Validation**
```bash
# 1. Clean compilation without warnings
javac -Xlint:all -Xdiags:verbose -d bin src/edu/ccrm/**/*.java

# 2. Runtime test with assertions
java -ea -cp bin edu.ccrm.cli.Main

# 3. Memory and performance check
java -Xmx512M -XX:+PrintGCDetails -cp bin edu.ccrm.cli.Main

# 4. Sample data processing test
# Use menu options to import test-data/*.csv files
```

#### **📊 Functionality Testing**
```bash
# Test Scenario 1: Student Management
# 1. Add students from test-data/students.csv
# 2. List students (verify sorting by regNo)
# 3. Deactivate a student
# 4. Verify student is marked inactive

# Test Scenario 2: Course Operations
# 1. Add courses from test-data/courses.csv
# 2. Search by department
# 3. Filter by semester
# 4. Verify credit calculations

# Test Scenario 3: Enrollment & Grades
# 1. Enroll students in courses
# 2. Record marks for enrolled students
# 3. Generate transcripts
# 4. Verify GPA calculations
```

#### **🔍 Error Handling Validation**
```bash
# Test invalid inputs
# 1. Invalid registration numbers (wrong format)
# 2. Invalid email addresses
# 3. Credit limits exceeded
# 4. Duplicate enrollments
# 5. File not found scenarios
```

### **📈 Performance Benchmarks**
```bash
# Minimum Performance Requirements:
# - Startup time: < 5 seconds
# - Student search: < 1 second for 1000 records
# - Course filtering: < 2 seconds for 500 courses
# - GPA calculation: < 1 second per student
# - CSV import: < 10 seconds for 1000 records
```

## 🏆 Final Submission Standards

### **📦 Deliverable Structure**
```
📁 FINAL_SUBMISSION/
├── 📂 src/              # Complete source code
├── 📂 bin/              # Compiled classes (optional)
├── 📂 test-data/        # All test files
├── 📂 screenshots/      # Application screenshots
├── 📄 README.md         # Updated documentation
├── 📄 USAGE.md          # Complete user guide
├── 📄 requirements.md   # This file
├── 📄 DISCLOSURE.md     # Academic integrity statement
└── 📄 *.java           # Test files (TestRegex, etc.)
```

### **✅ Quality Assurance Checklist**
- [ ] 📝 **Code compiles** without any warnings or errors
- [ ] 🧪 **All functionality tested** with provided sample data
- [ ] 📄 **Documentation complete** and up-to-date
- [ ] 🔍 **No external dependencies** added
- [ ] 📊 **Console output matches** specified format exactly
- [ ] ⚠️ **Error handling implemented** for all edge cases
- [ ] 🎯 **Business rules enforced** (credit limits, validation, etc.)
- [ ] 📁 **File structure preserved** exactly as specified
- [ ] 🏷️ **Academic integrity** statement included
- [ ] 📋 **Requirements met** completely

---

**🎓 Ready for submission when all checklist items are ✅ completed!**
