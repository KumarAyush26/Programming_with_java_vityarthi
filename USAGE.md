🎓 Campus Course & Records Manager (CCRM)
Complete Usage & Setup Handbook

A full-featured Java-based academic record and course management system

🚀 Quick Launch Checklist

Before starting, make sure the following are ready:

✅ Java 17+ installed (mandatory)
✅ Command-line/Terminal access
✅ Sample data files (included in test-data/)
✅ Write permissions for the project directory
✅ Around 500 MB of free disk space (recommended)

⚡ Fast Setup in 30 Seconds
# 1️⃣ Clone or download the repository
# 2️⃣ Go to the project folder
cd Programming-in-Java---Project-1-main

# 3️⃣ Compile & run in one shot
mkdir bin && javac -d bin src/edu/ccrm/**/*.java && java -ea -cp bin edu.ccrm.cli.Main

🔧 Detailed Build & Run Steps
# Step 1: Create output folder
mkdir bin     # Windows: md bin

# Step 2: Compile with extra warnings
javac -Xlint:all -d bin -cp src src/edu/ccrm/**/*.java

# Step 3: Confirm compilation
ls bin/edu/ccrm/

# Step 4: Start with assertions enabled
java -ea -cp bin edu.ccrm.cli.Main

# Optional: start in debug mode
java -ea -Xdebug -cp bin edu.ccrm.cli.Main

🏠 Main Dashboard

Launching CCRM displays:

╔════════════════════════════════════════════╗
║     🎓 Campus Course & Records Manager     ║
║               Version 2.0                  ║
╚════════════════════════════════════════════╝


Main menu options:

1️⃣ Student Management
2️⃣ Course Management
3️⃣ Enrollment & Grades
4️⃣ Data Import/Export
5️⃣ Backup & Reports
6️⃣ System Utilities
0️⃣ Exit

👥 Student Management

Add Students – Path: Main → 1 → a
Format: id,regNo,fullName,email
Example:

STU001,CS123456,John Doe,john.doe@university.edu


List Students – Path: Main → 1 → b
Shows active students sorted by registration number.

Deactivate/Reactivate – Path: Main → 1 → c
Mark a student inactive; can be restored later.

Advanced Tools – Path: Main → 1 → d
Search by name/email, view GPA stats, or list top performers (≥8.5 GPA).

📚 Course Management

Add Courses – Path: Main → 2 → a
Input: code,title,credits,department
Example:

CS101,Intro to Programming,3,Computer Science


List Courses – Path: Main → 2 → b
Displays all active courses with instructor and credits.

Search & Reports – Path: Main → 2 → d–h
Filter by department, instructor, semester, or run statistics.

🎓 Enrollment & Grading

Enroll Students – Path: Main → 3 → a
Validates student, course, credit limits, and prerequisites.

Record Marks – Path: Main → 3 → b
Marks → Grade conversion:

Marks	Grade	Points
90–100	S	10.0
80–89	A	9.0
70–79	B	8.0
60–69	C	7.0
50–59	D	6.0
40–49	E	5.0
0–39	F	0.0

Generate Transcripts – Path: Main → 3 → c
Print official GPA and semester summary.

📥📤 Data Exchange

Import CSVs – Path: Main → 4 → a
Supports students.csv, courses.csv, enrollments.csv, grades.csv.

Export Data – Path: Main → 4 → b
Output to CSV/JSON/XML with optional date filters.

💾 Backup & Reports

Backup Types – Path: Main → 5 → a

Full system backup

Data-only snapshot

Incremental changes

Reports – Path: Main → 5 → c
Generate enrollment trends, department analysis, GPA statistics, and audit logs.

📊 File Formats

students.csv

id,regNo,fullName,email
STU001,CS123456,John Doe,john.doe@university.edu


regNo: 2–3 uppercase letters + 6 digits

courses.csv

code,title,credits,instructor,semester,department
CS101,Introduction to Programming,3,Dr. Smith,FALL,Computer Science


…and similarly for enrollments.csv and grades.csv.

⚖️ Academic Policies

Credits per semester:

Regular: max 30

High achievers (GPA ≥ 8.5): max 33

Minimum to stay enrolled: 12

Graduation: 120+ total credits.

🛠️ Troubleshooting

Compilation Error:
package edu.ccrm.domain does not exist
👉 Verify folder structure and recompile:

rm -rf bin
mkdir bin
javac -d bin src/edu/ccrm/**/*.java


Runtime Error:
Could not find or load main class
👉 Check classpath and Main.class existence.

Memory Issues:
Increase heap size:

java -Xmx2G -cp bin edu.ccrm.cli.Main

💡 Tips & Best Practices

Use batch import for >1000 records.

Archive past semester data to improve speed.

Enable audit logging for security.

Perform daily backups and verify integrity.

📞 Help & Support

First consult this manual and error logs in logs/.

Test with the provided test-data/ files.

For academic/course-related issues, contact your instructor or TA.

Version 2.0 | Last Update: January 2024
🎉 Enjoy seamless academic record management with CCRM!
