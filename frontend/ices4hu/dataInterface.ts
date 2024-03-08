interface ISemesterRequest {
    name: string,
    start_date: Date,
    end_date: Date,
    is_active: boolean
}

interface ISemester extends ISemesterRequest {
    semester_id: number
}

interface IDepartment {
    department_id: number,
    name: string
}

interface IAccountRequest {
    account_type: "student" | "instructor" | "departmentManager",
    department_id: number,
    manager_of?: number,
    username: string,
    name: string,
    surname: string,
    email: string,
    profile_picture_url: string
}

interface IAccount extends IAccountRequest {
    id: number,
    department_name: string,
    is_banned?: boolean
}


interface ICourseRequest {
    department_id: number,
    name: string,
    credits: number
}

interface ICourse extends ICourseRequest {
    course_id: number,
    department_name: string
}

interface ISectionRequest {
    course_id: number,
    instructor_id: number,
    semester_id: number,
    section_no: number
}

interface ISection extends ISectionRequest {
    section_id: number,
    course_name: number,
    instructor_name: string,
    instructor_surname: string,
    semester_name: string
}

interface IQuestionRequest {
    written_by_instructor: number,
    written_by_department: number,
    course_id: number,
    question_type: string,
    is_for_course: boolean,
    is_required: boolean,
    question_title: string,
    question_text: string,
    question_image_url: string,
    choiceA: string,
    choiceB: string,
    choiceC: string,
    choiceD: string,
    choiceE: string
}

interface IQuestion extends IQuestionRequest {
    question_id: number,
    written_by_instructor_name: string,
    written_by_instructor_surname: string,
    written_by_department_name: string,
    course_name: string
}

interface ISurveyRequest {
    section_id: number
    is_for_course: boolean,
    is_submitted: boolean,
    do_it_later_count: number,
    is_reevaluate_request_sent: boolean,
    start_date: Date,
    end_date: Date
}

interface ISurvey extends ISurveyRequest {
    survey_id: number,
    course_name: string,
    instructor_name: string,
    instructor_surname: string,
    semester_name: string
}

interface IEvaluationAnswerRequest {
    evaluation_id: number,
    question_id: number,
    is_choiceA_selected: boolean,
    is_choiceB_selected: boolean,
    is_choiceC_selected: boolean,
    is_choiceD_selected: boolean,
    is_choiceE_selected: boolean,
    open_ended_answer: string
}

interface IEvaluationAnswer extends IEvaluationAnswerRequest {
    answer_id: number,
    question_title: string,
    question_text: string,
    section_id: number,
    is_for_course: boolean
}