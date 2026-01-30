# Database Schema Documentation

**Generated:** January 29, 2026  
**Application:** SDLC Backend Application

---

## Table of Contents
1. [Overview](#overview)
2. [Table Definitions](#table-definitions)
3. [Relationships](#relationships)
4. [Summary Statistics](#summary-statistics)

---

## Overview

This document describes the complete database schema for the SDLC Backend Application. The database uses PostgreSQL and manages job posting, job seeking, applications, and interviews.

---

## Table Definitions

### 1. user_table
**Primary Purpose:** Core user information for both job seekers and employers  
**Row Count:** 2  
**Schema:** public

| Column | Data Type | Nullable | Primary Key | Unique | Notes |
|--------|-----------|----------|-------------|--------|-------|
| user_id | BIGINT | NO | ✓ | | User identifier |
| first_name | VARCHAR | YES | | | User's first name |
| last_name | VARCHAR | YES | | | User's last name |
| email | VARCHAR | YES | | ✓ | User's email address |
| password | VARCHAR | YES | | | Hashed password |
| address | VARCHAR | YES | | | User's address |
| role | VARCHAR | YES | | | User role (e.g., EMPLOYER, JOB_SEEKER) |
| created_at | TIMESTAMP | YES | | | Account creation timestamp |
| updated_at | TIMESTAMP | YES | | | Last update timestamp |

---

### 2. employer
**Primary Purpose:** Employer-specific profile information  
**Row Count:** 1  
**Schema:** public  
**Foreign Keys:** user_id → user_table(user_id)

| Column | Data Type | Nullable | Primary Key | Notes |
|--------|-----------|----------|-------------|-------|
| user_id | BIGINT | NO | ✓ | Foreign key to user_table |
| company_name | VARCHAR | YES | | Name of the company |
| industry | VARCHAR | YES | | Industry sector |
| location | VARCHAR | YES | | Company location |

**Purpose:** Extends user_table with employer-specific information. One-to-one relationship with user_table.

---

### 3. job_seeker
**Primary Purpose:** Job seeker-specific profile information  
**Row Count:** 1  
**Schema:** public  
**Foreign Keys:** user_id → user_table(user_id)

| Column | Data Type | Nullable | Primary Key | Notes |
|--------|-----------|----------|-------------|-------|
| user_id | BIGINT | NO | ✓ | Foreign key to user_table |
| skills | VARCHAR | YES | | Comma-separated skills |
| resume_url | VARCHAR | YES | | URL to resume document |
| exp_years | INTEGER | NO | | Years of experience |

**Purpose:** Extends user_table with job seeker-specific information. One-to-one relationship with user_table.

---

### 4. job
**Primary Purpose:** Job postings created by employers  
**Row Count:** 1  
**Schema:** public  
**Foreign Keys:** employer_user_id → employer(user_id)

| Column | Data Type | Nullable | Primary Key | Notes |
|--------|-----------|----------|-------------|-------|
| job_id | BIGINT | NO | ✓ | Job identifier |
| employer_user_id | BIGINT | YES | | Foreign key to employer |
| title | VARCHAR | YES | | Job title |
| description | VARCHAR | YES | | Job description |
| job_type | VARCHAR | YES | | Type of job (e.g., FULL_TIME, PART_TIME) |
| requirements | VARCHAR | YES | | Job requirements |
| salary_range | VARCHAR | YES | | Salary range |
| status | VARCHAR | YES | | Job status (e.g., OPEN, CLOSED) |
| posted_date | DATE | YES | | Date job was posted |

**Purpose:** Stores job postings created by employers. One employer can post multiple jobs.

---

### 5. application
**Primary Purpose:** Job applications submitted by job seekers  
**Row Count:** 0  
**Schema:** public  
**Foreign Keys:** 
- job_id → job(job_id)
- seeker_id → job_seeker(user_id)

| Column | Data Type | Nullable | Primary Key | Notes |
|--------|-----------|----------|-------------|-------|
| app_id | BIGINT | NO | ✓ | Application identifier |
| job_id | BIGINT | YES | | Foreign key to job |
| seeker_id | BIGINT | YES | | Foreign key to job_seeker |
| status | VARCHAR | YES | | Application status (e.g., PENDING, ACCEPTED, REJECTED) |
| applied_date | DATE | YES | | Date of application |

**Purpose:** Tracks job applications submitted by job seekers. Links job seekers to job postings.

---

### 6. interview
**Primary Purpose:** Interview scheduling and results  
**Row Count:** 0  
**Schema:** public  
**Foreign Keys:** app_id → application(app_id)

| Column | Data Type | Nullable | Primary Key | Notes |
|--------|-----------|----------|-------------|-------|
| interview_id | BIGINT | NO | ✓ | Interview identifier |
| app_id | BIGINT | YES | | Foreign key to application |
| mode | VARCHAR | YES | | Interview mode (e.g., PHONE, VIDEO, IN_PERSON) |
| sched_date | DATE | YES | | Scheduled interview date |
| result | VARCHAR | YES | | Interview result (e.g., PASS, FAIL, PENDING) |
| feedback | VARCHAR | YES | | Interviewer feedback |

**Purpose:** Manages interview scheduling and tracking for applications.

---

### 7. token
**Primary Purpose:** JWT token management for user sessions  
**Row Count:** 56  
**Schema:** public  
**Foreign Keys:** userid → user_table(user_id)

| Column | Data Type | Nullable | Primary Key | Notes |
|--------|-----------|----------|-------------|-------|
| id | BIGINT | NO | ✓ | Token identifier |
| userid | BIGINT | YES | | Foreign key to user_table |
| jwttoken | VARCHAR | YES | | JWT token string |
| is_expired | BOOLEAN | NO | | Token expiration status |
| is_revoked | BOOLEAN | NO | | Token revocation status |

**Purpose:** Stores JWT tokens for user authentication and session management.

---

## Relationships

### Entity Relationship Diagram (Text Format)

```
user_table (2 rows)
├── [1:1] employer (1 row)
│   └── [1:M] job (1 row)
│       └── [1:M] application (0 rows)
│           └── [1:M] interview (0 rows)
├── [1:1] job_seeker (1 row)
│   └── [1:M] application (0 rows)
│       └── [1:M] interview (0 rows)
└── [1:M] token (56 rows)
```

### Relationship Details

| Relationship | Type | Description |
|-------------|------|-------------|
| user_table → employer | 1:1 | One user can have one employer profile |
| user_table → job_seeker | 1:1 | One user can have one job seeker profile |
| user_table → token | 1:M | One user can have multiple tokens |
| employer → job | 1:M | One employer can post multiple jobs |
| job → application | 1:M | One job can receive multiple applications |
| job_seeker → application | 1:M | One job seeker can submit multiple applications |
| application → interview | 1:M | One application can have multiple interviews |

---

## Summary Statistics

### Overview
- **Total Tables:** 7
- **Total Columns:** 42
- **Total Rows (all tables):** 61

### Table Row Counts
| Table | Rows | Status |
|-------|------|--------|
| token | 56 | Active (Many tokens stored) |
| user_table | 2 | Minimal data |
| job | 1 | Sample data |
| employer | 1 | Sample data |
| job_seeker | 1 | Sample data |
| application | 0 | No applications |
| interview | 0 | No interviews |

### Column Distribution by Data Type
| Data Type | Count | Tables |
|-----------|-------|--------|
| VARCHAR | 26 | Most fields |
| BIGINT | 12 | Primary/Foreign keys |
| TIMESTAMP | 2 | user_table audit fields |
| DATE | 5 | job, application, interview |
| INTEGER | 1 | job_seeker.exp_years |
| BOOLEAN | 2 | token flags |

### Primary Keys
- All tables have a primary key defined
- Most use BIGINT for ID fields
- email in user_table is also unique

### Constraints
- **Primary Keys:** 7
- **Unique Constraints:** 1 (user_table.email)
- **Foreign Key Relationships:** 7 (implicit from design)

---

## Notes

1. **User Roles:** The `role` field in user_table determines whether a user is an EMPLOYER or JOB_SEEKER
2. **Token Management:** The token table is actively used (56 rows) for JWT-based authentication
3. **Sample Data:** Most tables contain minimal sample data, indicating this is a development/test database
4. **Data Integrity:** Consider adding explicit foreign key constraints at the database level for referential integrity
5. **Audit Trail:** user_table includes created_at and updated_at timestamps for audit purposes

---

**End of Schema Documentation**
