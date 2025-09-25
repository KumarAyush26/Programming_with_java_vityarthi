# 📚 CCRM Usage Guide - Complete User Manual

<div align="center">

[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg?style=for-the-badge&logo=openjdk)](https://openjdk.java.net/)
[![License](https://img.shields.io/badge/License-Academic-blue.svg?style=for-the-badge)](DISCLOSURE.md)
[![Status](https://img.shields.io/badge/Status-Production%20Ready-success.svg?style=for-the-badge)](README.md)

**🎓 Campus Course & Records Manager - Complete User Guide**  
*Professional-grade student information system for academic institutions*

</div>

---

## 🚀 Quick Start Guide

### **📋 Prerequisites Checklist**
```bash
✅ Java 17 or higher (required)
✅ Command line terminal access
✅ Test data files (included in test-data/)
✅ Write permissions in project directory
✅ 500MB+ free disk space (recommended)
```

### **⚡ Fast Setup (30 seconds)**
```bash
# 1️⃣ Clone/Download the project
# 2️⃣ Navigate to project directory
cd Programming-in-Java---Project-1-main

# 3️⃣ One-command setup and run
mkdir bin && javac -d bin src/edu/ccrm/**/*.java && java -ea -cp bin edu.ccrm.cli.Main
```

### **🔧 Detailed Setup Process**
```bash
# Step 1: Create output directory
mkdir bin
# Windows: md bin

# Step 2: Compile with verbose output
javac -Xlint:all -d bin -cp src src/edu/ccrm/**/*.java

# Step 3: Verify compilation success
ls bin/edu/ccrm/  # Should show: cli/ config/ domain/ io/ service/ util/

# Step 4: Run with assertions enabled
java -ea -cp bin edu.ccrm.cli.Main

# Alternative: Run with debugging info
java -ea -Xdebug -cp bin edu.ccrm.cli.Main
```

---

## 🎯 Application Navigation Guide

### **🏠 Main Menu Overview**
When you start CCRM, you'll see:
```
╔══════════════════════════════════════════════════════════════╗
║            🎓 Campus Course & Records Manager                ║
║                        CCRM v2.0                            ║
╚══════════════════════════════════════════════════════════════╝

📚 Main Menu:
1️⃣  Student Management
2️⃣  Course Management  
3️⃣  Enrollment & Grades
4️⃣  Import/Export Data
5️⃣  Backup & Reports
6️⃣  System Utilities
0️⃣  Exit Application

Enter your choice [0-6]: _
```

---

## 👥 1. Student Management Module

### **📝 Adding Students**
```
Menu Path: Main → 1 → a

Input Format: id,regNo,fullName,email
Example: STU001,CS123456,John Doe,john.doe@university.edu

✅ Valid Examples:
STU001,CS123456,John Doe,john.doe@university.edu
STU002,CSE789012,Jane Smith,jane.smith@university.edu
STU003,IT345678,Bob Johnson,bob.johnson@university.edu

❌ Invalid Examples:
STU001,cs123456,John Doe,john@email.com     ❌ Lowercase regNo
STU002,CSE12345,Jane Smith,jane@email.com   ❌ Wrong regNo length
STU003,CSED123456,Bob Johnson,bob@email.com ❌ Too many letters in regNo
```

### **📋 Listing Students**
```
Menu Path: Main → 1 → b

Output Format:
╔════════════════════════════════════════════════════════════════════════╗
║                           ACTIVE STUDENTS                             ║
╠════════════════════════════════════════════════════════════════════════╣
║ ID      │ Reg No    │ Full Name        │ Email                        ║
╠─────────┼───────────┼──────────────────┼──────────────────────────────╢
║ STU001  │ CS123456  │ John Doe         │ john.doe@university.edu      ║
║ STU002  │ CSE789012 │ Jane Smith       │ jane.smith@university.edu    ║
╚════════════════════════════════════════════════════════════════════════╝

📊 Total Active Students: 2
🔍 Sorted by: Registration Number (ascending)
```

### **🚫 Deactivating Students**
```
Menu Path: Main → 1 → c

Process:
1. Enter registration number: CS123456
2. Confirm deactivation: y/n
3. Student marked as inactive (hidden from lists)

⚠️  Note: Deactivated students can be reactivated through database
```

### **🔍 Advanced Student Operations**
```
Menu Path: Main → 1 → d (Advanced Options)

Available Operations:
- 🔍 Search by name pattern
- 📧 Search by email domain
- 📊 Generate student statistics
- 📈 View enrollment summary
- 🏆 List high performers (GPA ≥ 8.5)
```

---

## 📚 2. Course Management Module

### **➕ Adding Courses**
```
Menu Path: Main → 2 → a

Input Format: code,title,credits,department
Example: CS101,Introduction to Programming,3,Computer Science

✅ Valid Examples:
CS101,Introduction to Programming,3,Computer Science
MATH201,Calculus II,4,Mathematics  
PHYS301,Quantum Physics,3,Physics
ENG102,Technical Writing,2,English

❌ Invalid Examples:
cs101,Programming,3,CS              ❌ Lowercase course code
CS1,Programming,3,Computer Science  ❌ Course code too short
CS101,Programming,0,Computer Science ❌ Invalid credit count
CS101,Programming,6,Computer Science ❌ Exceeds max credits (5)
```

### **📋 Listing Courses**
```
Menu Path: Main → 2 → b

Output Format:
╔══════════════════════════════════════════════════════════════════════════════════╗
║                                ACTIVE COURSES                                    ║
╠══════════════════════════════════════════════════════════════════════════════════╣
║ 🏢 COMPUTER SCIENCE DEPARTMENT                                                   ║
╠──────────┬─────────────────────────────────┬─────────┬──────────────────────────╢
║ Code     │ Title                           │ Credits │ Instructor               ║
╠──────────┼─────────────────────────────────┼─────────┼──────────────────────────╢
║ CS101    │ Introduction to Programming     │    3    │ Dr. Smith                ║
║ CS201    │ Data Structures                 │    4    │ Prof. Johnson            ║
║ CS301    │ Algorithms                      │    3    │ Dr. Williams             ║
╚══════════════════════════════════════════════════════════════════════════════════╝

📊 Total Courses: 15 | 📈 Average Credits: 3.2 | 🏢 Departments: 5
```

### **🔍 Course Search Options**
```
Menu Path: Main → 2 → d,e,f,g

d) 🏢 Search by Department
   Input: Computer Science
   Results: All CS department courses

e) 👨‍🏫 Search by Instructor  
   Input: Dr. Smith
   Results: All courses taught by Dr. Smith

f) 📅 Search by Semester
   Input: FALL, SPRING, or SUMMER
   Results: Courses offered in selected semester

g) 🔍 Advanced Search
   Multiple criteria:
   - Department + Credit range
   - Instructor + Semester
   - Title keyword search
```

### **📊 Course Statistics**
```
Menu Path: Main → 2 → h

Report Output:
╔═══════════════════════════════════════════════════════════════╗
║                    📊 COURSE STATISTICS                       ║
╠═══════════════════════════════════════════════════════════════╣
║ 📈 Total Active Courses: 45                                  ║
║ 🏢 Total Departments: 8                                      ║
║ 📚 Average Credits per Course: 3.2                           ║
║ 📊 Credit Distribution:                                       ║
║    • 1-2 credits: 8 courses (18%)                           ║
║    • 3 credits: 25 courses (56%)                            ║
║    • 4+ credits: 12 courses (27%)                           ║
║                                                               ║
║ 🏆 Top Departments by Course Count:                          ║
║    1. Computer Science: 12 courses                           ║
║    2. Mathematics: 8 courses                                 ║
║    3. Physics: 6 courses                                     ║
╚═══════════════════════════════════════════════════════════════╝
```

---

## 🎓 3. Enrollment & Grades Module

### **📝 Student Enrollment**
```
Menu Path: Main → 3 → a

Process:
1. Enter student registration number: CS123456
2. Enter course code: CS101
3. System validates:
   ✅ Student exists and is active
   ✅ Course exists and is active
   ✅ No duplicate enrollment
   ✅ Credit limit not exceeded
   ✅ Prerequisites met (if any)

Success Message:
🎉 Successfully enrolled CS123456 in CS101
📊 Current semester credits: 12/30
📈 Remaining credit capacity: 18
```

### **📊 Recording Marks**
```
Menu Path: Main → 3 → b

Input Process:
1. Enter student reg number: CS123456
2. Enter course code: CS101  
3. Enter marks (0-100): 85
4. System converts to grade:

📊 Marks to Grade Conversion:
90-100: S (Outstanding) - 10.0 points
80-89:  A (Excellent)   - 9.0 points  
70-79:  B (Good)        - 8.0 points
60-69:  C (Average)     - 7.0 points
50-59:  D (Below Avg)   - 6.0 points
40-49:  E (Poor)        - 5.0 points
0-39:   F (Fail)        - 0.0 points

✅ Grade recorded: A (85 marks) - 9.0 points
```

### **🎓 Transcript Generation**
```
Menu Path: Main → 3 → c

Input: Student registration number (CS123456)

Sample Transcript Output:
╔═══════════════════════════════════════════════════════════════════════════╗
║                            🎓 OFFICIAL TRANSCRIPT                         ║
╠═══════════════════════════════════════════════════════════════════════════╣
║ Student: John Doe                    Reg No: CS123456                     ║
║ Email: john.doe@university.edu       Generated: 2024-01-15 14:30:25       ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                           📚 ACADEMIC RECORD                             ║
╠═══════════════════════════════════════════════════════════════════════════╣
║ Course   │ Title                    │ Credits │ Grade │ Points │ Semester ║
╠══════════┼══════════════════════════┼═════════┼═══════┼════════┼══════════╢
║ CS101    │ Intro to Programming     │    3    │   A   │  9.0   │  FALL    ║
║ MATH201  │ Calculus II              │    4    │   B   │  8.0   │  FALL    ║
║ PHYS101  │ Physics I                │    3    │   A   │  9.0   │  FALL    ║
║ ENG102   │ Technical Writing        │    2    │   S   │ 10.0   │  FALL    ║
╠══════════┼══════════════════════════┼═════════┼═══════┼════════┼══════════╢
║ 📊 SEMESTER TOTALS                   │   12    │       │ 108.0  │          ║
╚═══════════════════════════════════════════════════════════════════════════╝

🎯 Semester GPA: 9.0/10.0
🏆 Classification: First Class with Distinction
📈 Credit Hours Completed: 12
⚠️  Minimum 120 credits required for graduation
```

---

## 📥📤 4. Import/Export Data Module

### **📥 Data Import Operations**
```
Menu Path: Main → 4 → a

Supported File Formats:
📄 students.csv - Student data import
📄 courses.csv - Course data import  
📄 enrollments.csv - Enrollment data import
📄 grades.csv - Grade data import

Import Process:
1. Select import type: students/courses/enrollments/grades
2. Enter file path: test-data/students.csv
3. System validates file format
4. Preview first 5 records
5. Confirm import: y/n
6. Process with error reporting

Success Output:
✅ Import completed successfully!
📊 Records processed: 150
✅ Successfully imported: 147
❌ Failed records: 3
📄 Error log saved to: imports/errors_2024-01-15.log
```

### **📤 Data Export Operations**
```
Menu Path: Main → 4 → b

Export Options:
1. 👥 Export All Students
2. 📚 Export All Courses  
3. 🎓 Export Enrollments
4. 📊 Export Grades/Transcripts
5. 📈 Export System Reports
6. 💾 Full Database Export

Export Process:
1. Select export type
2. Choose format: CSV/JSON/XML
3. Enter destination path
4. Select date range (if applicable)
5. Configure options (active only/include inactive)

Output Files:
📄 students_export_2024-01-15.csv
📄 courses_export_2024-01-15.csv
🏷️  Tagged with timestamp for version control
```

---

## 💾 5. Backup & Reports Module

### **💾 Backup Operations**
```
Menu Path: Main → 5 → a

Backup Types:
1. 📁 Full System Backup
   - All data files
   - Configuration files
   - Log files
   
2. 📊 Data-only Backup
   - Student records
   - Course records
   - Enrollment data
   
3. 🔧 Incremental Backup
   - Changes since last backup
   - Faster, smaller size

Backup Process:
1. Select backup type
2. Choose destination directory
3. System creates timestamped backup
4. Verification and integrity check
5. Backup summary report

Backup Structure:
backup_CCRM_2024-01-15_14-30-25/
├── 📂 data/           # All CSV files
├── 📂 config/         # Configuration files  
├── 📂 logs/           # Application logs
├── 📄 manifest.txt    # Backup inventory
└── 📄 checksum.md5    # Integrity verification
```

### **📊 System Reports**
```
Menu Path: Main → 5 → c

Available Reports:
1. 📈 Enrollment Statistics
2. 📚 Course Utilization
3. 🎓 Academic Performance
4. 👥 Student Demographics  
5. 🏢 Department Analysis
6. 📅 Semester Summary
7. 🔍 System Audit Log

Sample Report (Enrollment Statistics):
╔═══════════════════════════════════════════════════════════════╗
║                   📈 ENROLLMENT STATISTICS                    ║
║                      Academic Year 2024                      ║
╠═══════════════════════════════════════════════════════════════╣
║ 📊 Total Students: 1,247                                     ║
║ 📚 Total Courses: 156                                        ║
║ 🎓 Total Enrollments: 4,892                                  ║
║ 📈 Average Enrollments per Student: 3.9                      ║
║ 📊 Average Students per Course: 31.4                         ║
║                                                               ║
║ 🏆 Top Performing Departments:                               ║
║    1. Computer Science (avg GPA: 8.7)                       ║
║    2. Mathematics (avg GPA: 8.3)                            ║
║    3. Physics (avg GPA: 8.1)                                ║
║                                                               ║
║ 📈 Enrollment Trends:                                        ║
║    • Fall Semester: 67% of total enrollments               ║  
║    • Spring Semester: 28% of total enrollments             ║
║    • Summer Semester: 5% of total enrollments              ║
╚═══════════════════════════════════════════════════════════════╝
```

---

## 📋 Data File Formats & Examples

### **📄 students.csv Format**
```csv
# Header (required)
id,regNo,fullName,email

# Data rows
STU001,CS123456,John Doe,john.doe@university.edu
STU002,CSE789012,Jane Smith,jane.smith@university.edu
STU003,IT345678,Bob Johnson,bob.johnson@university.edu
STU004,ECE456789,Alice Williams,alice.williams@university.edu

# ✅ Requirements:
# - id: Unique student identifier (STU001, STU002, etc.)
# - regNo: 2-3 uppercase letters + 6 digits (CS123456, CSE789012)
# - fullName: Full legal name (First Last or First Middle Last)
# - email: Valid email format (name@domain.com)
```

### **📚 courses.csv Format**
```csv
# Header (required)
code,title,credits,instructor,semester,department

# Data rows
CS101,Introduction to Programming,3,Dr. Smith,FALL,Computer Science
CS201,Data Structures,4,Prof. Johnson,SPRING,Computer Science
MATH201,Calculus II,4,Dr. Williams,FALL,Mathematics
PHYS301,Quantum Physics,3,Prof. Davis,SPRING,Physics

# ✅ Requirements:
# - code: 2-4 uppercase letters + 3 digits (CS101, MATH201)
# - title: Course title (max 100 characters)
# - credits: Integer 1-5
# - instructor: Optional instructor name
# - semester: FALL, SPRING, or SUMMER
# - department: Department name
```

### **🎓 enrollments.csv Format**
```csv
# Header (required)
studentRegNo,courseCode,semester,enrollmentDate

# Data rows
CS123456,CS101,FALL,2024-08-15
CS123456,MATH201,FALL,2024-08-15
CSE789012,CS101,FALL,2024-08-16
IT345678,PHYS301,SPRING,2024-01-10

# ✅ Requirements:
# - studentRegNo: Must match existing student
# - courseCode: Must match existing course
# - semester: FALL, SPRING, or SUMMER  
# - enrollmentDate: YYYY-MM-DD format
```

### **📊 grades.csv Format**
```csv
# Header (required)
studentRegNo,courseCode,marks,grade,semester

# Data rows
CS123456,CS101,85,A,FALL
CS123456,MATH201,78,B,FALL
CSE789012,CS101,92,S,FALL
IT345678,PHYS301,73,B,SPRING

# ✅ Requirements:
# - studentRegNo: Must match enrolled student
# - courseCode: Must match enrolled course
# - marks: Integer 0-100
# - grade: S,A,B,C,D,E,F (auto-calculated if empty)
# - semester: Must match enrollment semester
```

---

## ⚖️ Business Rules & Validation

### **📏 Academic Standards**
```
🎓 CREDIT REQUIREMENTS:
├── 📊 Regular Students: Max 30 credits/semester
├── 🏆 High Performers (GPA ≥ 8.5): Max 33 credits/semester  
├── 🎯 Minimum Enrollment: 12 credits/semester
├── 🎓 Graduation Requirement: 120+ total credits
└── ⚠️  Summer Limit: Max 15 credits

📊 GRADE POINT SYSTEM:
├── S (90-100): 10.0 points - Outstanding
├── A (80-89):  9.0 points - Excellent
├── B (70-79):  8.0 points - Good
├── C (60-69):  7.0 points - Average
├── D (50-59):  6.0 points - Below Average
├── E (40-49):  5.0 points - Poor
└── F (0-39):   0.0 points - Fail

🏆 GPA CLASSIFICATIONS:
├── 9.0-10.0: First Class with Distinction
├── 8.0-8.9:  First Class
├── 7.0-7.9:  Second Class
├── 6.0-6.9:  Pass Class
└── <6.0:     Fail
```

### **✅ Validation Rules**
```
📝 REGISTRATION NUMBER:
✅ Format: [A-Z]{2,3}\d{6}
✅ Examples: CS123456, CSE789012, IT345678
❌ Invalid: cs123456, CSE12345, CSED123456

📧 EMAIL ADDRESS:
✅ Format: name@domain.ext
✅ Examples: john.doe@university.edu, student@college.org
❌ Invalid: @domain.com, name@, invalid-email

📚 COURSE CODE:
✅ Format: [A-Z]{2,4}\d{3}[A-Z]?
✅ Examples: CS101, MATH201, PHYS301A
❌ Invalid: cs101, MATH1, COMPUTING101

🏢 DEPARTMENT NAMES:
✅ Valid: Computer Science, Mathematics, Physics
✅ Max Length: 50 characters
❌ Invalid: CS, COMP_SCI, empty string
```

### **🔒 Data Integrity Rules**
```
🎯 ENROLLMENT CONSTRAINTS:
├── ✅ Student must be active
├── ✅ Course must be active
├── ✅ No duplicate enrollments
├── ✅ Credit limit validation
├── ✅ Prerequisite checking
└── ✅ Semester conflict detection

📊 GRADE CONSTRAINTS:
├── ✅ Student must be enrolled in course
├── ✅ Marks range: 0-100
├── ✅ Grade consistency check
├── ✅ GPA recalculation
└── ✅ Transcript updates

💾 DATA PERSISTENCE:
├── ✅ Automatic backup before major operations
├── ✅ Transaction rollback on errors
├── ✅ Data validation before save
├── ✅ Referential integrity maintenance
└── ✅ Audit trail logging
```

---

## 🐛 Troubleshooting & Error Resolution

### **⚠️ Common Issues & Solutions**

#### **🔴 Compilation Errors**
```bash
Error: "package edu.ccrm.domain does not exist"
💡 Solution:
   1. Verify directory structure: src/edu/ccrm/domain/
   2. Check package declarations in .java files
   3. Clean recompilation:
      rm -rf bin/
      mkdir bin
      javac -d bin src/edu/ccrm/**/*.java
```

#### **🔴 Runtime Errors**
```bash
Error: "Could not find or load main class edu.ccrm.cli.Main"
💡 Solution:
   1. Verify Main.class exists: ls bin/edu/ccrm/cli/Main.class
   2. Check classpath: java -cp "bin" edu.ccrm.cli.Main
   3. Recompile Main class:
      javac -d bin -cp src src/edu/ccrm/cli/Main.java
```

#### **🔴 Data Import Errors**
```bash
Error: "Invalid file format" during CSV import
💡 Solution:
   1. Check CSV headers match exactly
   2. Verify no empty lines at file end
   3. Ensure UTF-8 encoding: file -I yourfile.csv
   4. Validate data format in each column
   5. Check for special characters/commas in data
```

#### **🔴 Memory Issues**
```bash
Error: "OutOfMemoryError" with large datasets
💡 Solution:
   1. Increase heap size: java -Xmx2G -cp bin edu.ccrm.cli.Main
   2. Process files in batches
   3. Enable garbage collection logging:
      java -XX:+PrintGCDetails -cp bin edu.ccrm.cli.Main
```

### **🔍 Debug Mode Operations**
```bash
# Enable detailed logging
java -ea -Dlog.level=DEBUG -cp bin edu.ccrm.cli.Main

# Monitor file operations
java -ea -Dfile.debug=true -cp bin edu.ccrm.cli.Main

# Validate all business rules
java -ea -Dvalidation.strict=true -cp bin edu.ccrm.cli.Main
```

### **📞 Getting Help**
```
🆘 When you encounter issues:

1. 📋 Check this usage guide first
2. 📄 Review error messages carefully  
3. 🔍 Check log files in logs/ directory
4. 🧪 Test with sample data from test-data/
5. 📧 Report bugs with:
   - Error message (full stack trace)
   - Steps to reproduce
   - System information (OS, Java version)
   - Sample data that caused the issue

📚 Additional Resources:
- README.md: Project overview and setup
- requirements.md: Detailed technical requirements
- DISCLOSURE.md: Academic integrity guidelines
- Javadoc: API documentation (if generated)
```

---

## 💡 Pro Tips & Best Practices

### **🚀 Performance Optimization**
```
⚡ Speed Up Operations:
├── 💾 Use batch import for large datasets (>1000 records)
├── 🔍 Create indexes for frequent searches
├── 📊 Archive old semester data regularly
├── 🧹 Clean up inactive records periodically
└── 💿 Use SSD storage for better I/O performance

📈 Memory Management:
├── 🎯 Process large files in chunks
├── 🗑️  Close resources properly
├── 📊 Monitor memory usage with -Xms and -Xmx
└── 🔄 Restart application after heavy operations
```

### **🔒 Data Safety**
```
💾 Backup Strategy:
├── 📅 Daily automatic backups
├── 🗓️  Weekly full system backups
├── 📊 Test restore procedures monthly
├── 🌐 Store backups in multiple locations
└── ✅ Verify backup integrity regularly

🛡️  Security Best Practices:
├── 🔑 Restrict file permissions (600 for data files)
├── 📝 Enable audit logging
├── 👥 Limit user access to sensitive operations
├── 🔒 Encrypt sensitive data at rest
└── 🔄 Regular security updates
```

### **🎯 Academic Management**
```
📊 Semester Operations:
├── 🏁 End of semester: Export all grades
├── 🆕 New semester: Import new course offerings
├── 📈 Archive previous semester data
├── 🎓 Generate academic reports
└── 📋 Prepare enrollment statistics

🎓 Grade Management:
├── ✅ Verify all enrollments have grades
├── 📊 Calculate GPA after grade entry
├── 🏆 Identify students needing academic support
├── 📄 Generate official transcripts
└── 📈 Track academic progression
```

---

## 📞 Support & Contact Information

<div align="center">

**🎓 CCRM Development Team**

[![GitHub](https://img.shields.io/badge/GitHub-Repository-black.svg?style=for-the-badge&logo=github)](README.md)
[![Documentation](https://img.shields.io/badge/Docs-Complete-blue.svg?style=for-the-badge&logo=gitbook)](USAGE.md)
[![Academic](https://img.shields.io/badge/Academic-Project-orange.svg?style=for-the-badge&logo=academic)](DISCLOSURE.md)

**📧 For technical support, refer to your course instructor or TA**  
**📚 Complete documentation available in project README.md**

*Version 2.0 | Last Updated: January 2024*

</div>

---

**🎉 Thank you for using CCRM! Happy learning! 🚀**
