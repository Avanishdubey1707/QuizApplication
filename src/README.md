# 🧠 Quiz Application – Monolithic Spring Boot Project

## 📌 Overview
This repository contains a **Monolithic Quiz Application** developed using **Spring Boot**.  
The application provides REST APIs to manage quizzes, questions, and user participation.

This project represents the **initial monolithic architecture**, which is later used as a **baseline for migrating to a microservices-based architecture**.

---

## 🏗️ Architecture
- **Architecture Type:** Monolithic
- **Backend Framework:** Spring Boot
- **Build Tool:** Maven
- **Database:** MySQL (or H2 – update as applicable)
- **API Style:** RESTful APIs

All application layers (Controller, Service, Repository, Entity) are deployed as **a single unit**.

---

## 📂 Project Structure
quiz-application ├── controller     # REST Controllers ├── service        # Business Logic ├── repository     # Data Access Layer ├── entity         # JPA Entities ├── dto            # Data Transfer Objects (if any) └── QuizApplication.java