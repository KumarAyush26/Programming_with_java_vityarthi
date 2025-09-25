🎓 EduTrack Academic Management Suite (EAMS) — Complete User Guide

Professional student information system built in Java SE — usage, menus, examples, and file formats for the EduTrack Academic Management Suite (EAMS).

🚀 Quick Start
Prerequisites

Java JDK 17+ installed

Terminal (PowerShell, CMD, or Bash) access

test-data/ CSV files included with the project

Write permission in project folder

~500 MB free disk space (recommended)

Fast Setup (one-liner)
# from project root
cd EduTrack-EAMS-Main
mkdir bin && javac -d bin src/edu/eams/**/*.java && java -ea -cp bin edu.eams.cli.Main

🔧 Detailed Setup & Run
1. Create output directory
# Unix/macOS/Linux
mkdir bin

# Windows (CMD)
md bin

2. Compile (recommended)
javac -Xlint:all -d bin -cp src src/edu/eams/**/*.java

3. Verify compiled structure
ls bin/edu/eams/   # should show cli/ config/ domain/ io/ service/ util/

4. Run with assertions enabled (recommended for development)
java -ea -cp bin edu.eams.cli.Main

5. Debug / verbose options
# With debug logging
java -ea -Djava.util.logging.config.file=logging.properties -cp bin edu.eams.cli.Main

# With increased heap (large data)
java -Xmx1G -cp bin edu.eams.cli.Main

🏠 Application Navigation (Main Menu)

When you start EduTrack you’ll see a main menu similar to:

╔════════════════════════════════════════════════╗
║     🎓 EduTrack Academic Management Suite     ║
║                  EAMS v2.0                    ║
╚════════════════════════════════════════════════╝

1  Student Management
2  Course Management
3  Enrollment & Grades
4  Import / Export Data
5  Backup & Reports
6  System Utilities
0  Exit
Enter your choice [0-6]:

👥 1. Student Management
Add Student (Main → 1 → a)

Input format:

id,regNo,fullName,email


Example:

STU001,CS123456,John Doe,john.doe@university.edu


Valid regNo examples: CS123456, CSE789012, IT345678
Invalid: cs123456 (lowercase), CSE12345 (wrong digits), CSED123456 (too many letters)

List Students (Main → 1 → b)

Displays an active-students table, sorted (default) by registration number.

Deactivate / Reactivate (Main → 1 → c)

Enter registration number to deactivate (hidden from active lists).

Reactivation is supported via System Utilities or an admin option.

Advanced Student Tools (Main → 1 → d)

Search by name or email domain

Generate student statistics (GPA distributions, counts)

List high performers (GPA ≥ 8.5)

📚 2. Course Management
Add Course (Main → 2 → a)

Input format:

code,title,credits,department


Example:

CS101,Introduction to Programming,3,Computer Science


Course rules

Code: 2–4 uppercase letters + 3 digits (e.g., CS101)

Credits: integer, typically 1–6 (project default 1–6)

List Courses (Main → 2 → b)

Shows courses grouped by department with credits and assigned instructor.

Course Search (Main → 2 → d–g)

By Department

By Instructor

By Semester (FALL / SPRING / SUMMER)

Advanced: combine department + credit range, instructor + semester, title keyword

Course Stats (Main → 2 → h)

Reports: total courses, average credits, distribution by credit ranges, top departments by course count.

🎓 3. Enrollment & Grades
Enroll Student (Main → 3 → a)

Process:

Enter student regNo (e.g., CS123456)

Enter course code (e.g., CS101)

System validates:

student exists & active

course exists & active

no duplicate enrollment

credit limit not exceeded

prerequisites (if configured)

Success example:

Successfully enrolled CS123456 in CS101
Current semester credits: 12/30

Record Marks (Main → 3 → b)

Input:

Student regNo

Course code

Marks (0–100)

Marks → Grade mapping:

90–100: S (10.0)

80–89: A (9.0)

70–79: B (8.0)

60–69: C (7.0)

50–59: D (6.0)

40–49: E (5.0)

0–39: F (0.0)

Example feedback:

Grade recorded: A (85 marks) — 9.0 points

Transcript Generation (Main → 3 → c)

Generate a formatted transcript for a student with course list, credits, grades, semester totals, and GPA.

📥 4. Import / Export Data
Supported import files

students.csv — student records

courses.csv — course catalog

enrollments.csv — enrollment entries

grades.csv — grade records

Import workflow:

Choose import type

Enter file path (e.g., test-data/students.csv)

Preview first N records

Confirm and run import with error reporting

Import example output:

Import completed
Records processed: 150
Imported: 147
Failed: 3 -> error log: imports/errors_2024-01-15.log

Export options

Export students, courses, enrollments, grades, or full DB

Formats: CSV / JSON / XML

Files stamped with timestamps for versioning (e.g., students_export_2024-01-15.csv)

💾 5. Backup & Reports
Backup types

Full system backup (data + config + logs)

Data-only backup (CSV snapshots)

Incremental backup (changes since last backup)

Backup output structure:

backup_EduTrack_2024-01-15_14-30-25/
├─ data/
├─ config/
├─ logs/
├─ manifest.txt
└─ checksum.md5

Reports (Main → 5 → c)

Enrollment statistics, course utilization, academic performance, student demographics, department analysis, semester summary, audit logs.

📄 Data File Formats (Examples)
students.csv
# header required
id,regNo,fullName,email

# rows
STU001,CS123456,John Doe,john.doe@university.edu
STU002,CSE789012,Jane Smith,jane.smith@university.edu


regNo format: [A-Z]{2,3}\d{6}

courses.csv
code,title,credits,instructor,semester,department
CS101,Introduction to Programming,3,Dr. Smith,FALL,Computer Science


credits integer (1–6)

semester: FALL / SPRING / SUMMER

enrollments.csv
studentRegNo,courseCode,semester,enrollmentDate
CS123456,CS101,FALL,2024-08-15

grades.csv
studentRegNo,courseCode,marks,grade,semester
CS123456,CS101,85,A,FALL


grade can be auto-calculated if left empty

⚖️ Business Rules & Validation (Summary)
Credit policies

Standard per-semester max: 30 credits

High-performer allowance: 33 credits (GPA ≥ 8.5)

Minimum initial enrollment: 12 credits

Graduation requirement: 120+ total credits

Grade & GPA

Grade points: S(10) → A(9) → B(8) → C(7) → D(6) → E(5) → F(0)

GPA: weighted by credit hours; recalculated on grade change

Validation checks

Registration number pattern: [A-Z]{2,3}\d{6}

Email format: name@domain.ext

Course code: [A-Z]{2,4}\d{3}[A-Z]?

No duplicate enrollments; student and course must be active

🐛 Troubleshooting & Debug Guide
Compilation errors

package edu.eams.domain does not exist

Ensure src/edu/eams/ structure matches package declarations

Clean and recompile:

rm -rf bin && mkdir bin
javac -d bin -cp src src/edu/eams/**/*.java

Runtime errors

Could not find or load main class edu.eams.cli.Main

Verify Main.class exists: ls bin/edu/eams/cli/Main.class

Run with correct classpath: java -cp bin edu.eams.cli.Main

CSV import errors

Invalid file format

Check headers & encoding (use UTF-8)

No trailing empty lines, proper delimiters, valid field formats

OutOfMemory (large datasets)

Increase heap:

java -Xmx2G -cp bin edu.eams.cli.Main


Process imports in batches

🔍 Debug Modes & Logging

Enable detailed logging:

java -ea -Dlog.level=DEBUG -cp bin edu.eams.cli.Main


Enable file operation tracing:

java -ea -Dfile.debug=true -cp bin edu.eams.cli.Main


Enforce strict validation:

java -ea -Dvalidation.strict=true -cp bin edu.eams.cli.Main

📞 Getting Help

If you hit issues:

Read this guide and check logs/ for errors.

Test using provided CSVs in test-data/.

When reporting bugs, include:

Full error message / stack trace

Steps to reproduce

OS & Java version (java -version)

The CSV or sample data that triggered the issue

💡 Best Practices & Tips

Use batch import for large datasets (>1000 records).

Archive old semester data to boost performance.

Schedule daily backups and monthly restore tests.

Restrict file permissions for data files; enable audit logging.

Run with -ea (assertions) during development to catch logic issues early.

EduTrack Academic Management Suite (EAMS) — designed to be a robust educational tool and an excellent hands-on Java learning project.
If you want, I can now produce a cleaned README.md or USAGE.md file (ready to paste into your repo) using this corrected EduTrack wording — tell me which file you prefer.
