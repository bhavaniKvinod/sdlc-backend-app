-- =============================================================================
-- Database Schema for SDLC Backend Application
-- Generated: 2026-01-29
-- =============================================================================

-- Table: user_table
-- Description: Core user information for both job seekers and employers
-- Rows: 2
CREATE TABLE user_table (
    user_id BIGINT NOT NULL,
    first_name VARCHAR,
    last_name VARCHAR,
    email VARCHAR UNIQUE,
    password VARCHAR,
    address VARCHAR,
    role VARCHAR,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (user_id)
);

-- Table: employer
-- Description: Employer-specific profile information
-- Rows: 1
-- Foreign Key: user_id -> user_table(user_id)
CREATE TABLE employer (
    user_id BIGINT NOT NULL,
    company_name VARCHAR,
    industry VARCHAR,
    location VARCHAR,
    PRIMARY KEY (user_id)
);

-- Table: job_seeker
-- Description: Job seeker-specific profile information
-- Rows: 1
-- Foreign Key: user_id -> user_table(user_id)
CREATE TABLE job_seeker (
    user_id BIGINT NOT NULL,
    skills VARCHAR,
    resume_url VARCHAR,
    exp_years INTEGER NOT NULL,
    PRIMARY KEY (user_id)
);

-- Table: job
-- Description: Job postings created by employers
-- Rows: 1
-- Foreign Key: employer_user_id -> employer(user_id)
CREATE TABLE job (
    job_id BIGINT NOT NULL,
    employer_user_id BIGINT,
    title VARCHAR,
    description VARCHAR,
    job_type VARCHAR,
    requirements VARCHAR,
    salary_range VARCHAR,
    status VARCHAR,
    posted_date DATE,
    PRIMARY KEY (job_id)
);

-- Table: application
-- Description: Job applications submitted by job seekers
-- Rows: 0
-- Foreign Key: job_id -> job(job_id)
-- Foreign Key: seeker_id -> job_seeker(user_id)
CREATE TABLE application (
    app_id BIGINT NOT NULL,
    job_id BIGINT,
    seeker_id BIGINT,
    status VARCHAR,
    applied_date DATE,
    PRIMARY KEY (app_id)
);

-- Table: interview
-- Description: Interview scheduling and results
-- Rows: 0
-- Foreign Key: app_id -> application(app_id)
CREATE TABLE interview (
    interview_id BIGINT NOT NULL,
    app_id BIGINT,
    mode VARCHAR,
    sched_date DATE,
    result VARCHAR,
    feedback VARCHAR,
    PRIMARY KEY (interview_id)
);

-- Table: token
-- Description: JWT token management for user sessions
-- Rows: 56
-- Foreign Key: userid -> user_table(user_id)
CREATE TABLE token (
    id BIGINT NOT NULL,
    userid BIGINT,
    jwttoken VARCHAR,
    is_expired BOOLEAN NOT NULL,
    is_revoked BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

-- =============================================================================
-- Summary Statistics
-- =============================================================================
-- Total Tables: 7
-- Total Columns: 42
-- 
-- Tables by Row Count:
-- - token: 56 rows
-- - user_table: 2 rows
-- - job: 1 row
-- - employer: 1 row
-- - job_seeker: 1 row
-- - application: 0 rows
-- - interview: 0 rows
-- =============================================================================

-- =============================================================================
-- Relationships Overview
-- =============================================================================
-- user_table
--   ├── employer (1:1 via user_id)
--   ├── job_seeker (1:1 via user_id)
--   └── token (1:M via user_id -> userid)
--
-- employer
--   └── job (1:M via user_id -> employer_user_id)
--
-- job
--   └── application (1:M via job_id)
--
-- job_seeker
--   └── application (1:M via user_id -> seeker_id)
--
-- application
--   └── interview (1:M via app_id)
-- =============================================================================
