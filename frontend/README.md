# Todo list

- Admin component:

  - Admin username is admin and password is stored in ./backend/application.yml
  - Admin uses [a json file](./ices4hu/fromBILSIS.json) which is assumed to be taken from BILSIS like system. This json file contains fake semesters, departments, courses, instructors(some of them are department managers) and students.
  - Admin creates semesters using /api/v1/semesters endpoint.
  - Admin creates departments using /api/v1/departments endpoint.
  - Admin creates personnel using /api/v1/personnel endpoint.
  - Admin creates courses using /api/v1/courses endpoint.
  - Admin creates sections using /api/v1/sections endpoint.
  - Admin creates sectionEnrollment using /api/v1/sectionenrolments endpoint.
  - Admin sends passwords to department managers and instructors.
  - Admin selects last semesters start date and end date and starts it. (makes is_active true)
  - Admin approves student's enrolment requests and sends passwords to students. Admin creates new records in Students using /api/v1/students after enrollment. (is_enrolled as false)
  - Admin adds/removes students to a mergedEmail address.

- Department Manager Component:
  - Adds instructors to the courses.
