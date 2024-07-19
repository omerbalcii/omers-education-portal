import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS
import 'bootstrap/dist/js/bootstrap.bundle.min.js'; // Bootstrap JS
import { Container, Row, Col } from 'react-bootstrap';
import MenuComponent from './components/menu/MenuComponent'; // Örnek menü bileşeni
import CourseList from './components/Course/CourseList'; // Kurs listesi bileşeni
import CourseDetails from './components/Course/CourseDetails'; // Kurs detayı bileşeni
import CourseKaydetComponent from './components/Course/CourseKaydetComponent';
// import LoginComponent from './components/LoginComponent'; // Giriş bileşeni
import IndexComponent from './components/IndexComponent'; // Ana sayfa bileşeni
// import TeacherList from './components/TeacherList'; // Öğretmen listesi bileşeni
// import TeacherDetail from './components/TeacherDetail'; // Öğretmen detayı bileşeni
// import TeacherForm from './components/TeacherForm'; // Öğretmen formu bileşeni
// import StudentList from './components/StudentList'; // Öğrenci listesi bileşeni
// import StudentDetail from './components/StudentDetail'; // Öğrenci detayı bileşeni
// import StudentForm from './components/StudentForm'; // Öğrenci formu bileşeni
// import LessonList from './components/LessonList'; // Ders listesi bileşeni
// import LessonDetail from './components/LessonDetail'; // Ders detayı bileşeni
// import LessonForm from './components/LessonForm'; // Ders formu bileşeni

const App = () => (
  <BrowserRouter>
    <Container className="pt-3" fluid>
      <Row>
        <Col xs="2">
          <MenuComponent /> {/* Örnek menü bileşeni */}
        </Col>
        <Col xs="10">
          <Routes>
            <Route path="/" element={<IndexComponent />} />

            {/* Kurslar */}
            <Route path="/course" element={<CourseList />} />
            <Route path="/course/detail" element={<CourseDetails />} />
            < Route path="/course/save" element={<CourseKaydetComponent />} />
            {/* Öğretmenler
            <Route path="/teacher" element={<TeacherList />} />
            <Route path="/teacher/detail" element={<TeacherDetail />} />
            <Route path="/teacher/new" element={<TeacherForm />} />
            <Route path="/teacher/edit" element={<TeacherForm />} /> */}

            {/* Öğrenciler */}
            {/* <Route path="/student" element={<StudentList />} />
            <Route path="/student/detail" element={<StudentDetail />} />
            <Route path="/student/new" element={<StudentForm />} />
            <Route path="/student/edit" element={<StudentForm />} /> */}

        
            {/* Dersler */}
            {/* <Route path="/lesson" element={<LessonList />} />
            <Route path="/lesson/detail" element={<LessonDetail />} />
            <Route path="/lesson/new" element={<LessonForm />} />
            <Route path="/lesson/edit" element={<LessonForm />} /> */}

            {/* Giriş */}
            {/* <Route path="/login" element={<LoginComponent />} /> */}
          </Routes>
        </Col>
      </Row>
    </Container>
  </BrowserRouter>
);

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
