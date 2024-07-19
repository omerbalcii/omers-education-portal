import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Container, Row, Col } from "react-bootstrap";
import MenuComponent from "./components/menu/MenuComponent";
import CourseList from "./components/Course/CourseList";
import CourseDetail from "./components/Course/CourseDetails";
import CourseKaydetComponent from "./components/Course/CourseKaydetComponent";
// Diğer bileşenleri import edin

const App = () => {
  return (
    <BrowserRouter>
      <Container fluid>
        <Row>
          <Col xs={2}>
            <MenuComponent />
          </Col>
          <Col xs={10}>
            <Routes>
              <Route path="/" element={<h1>Anasayfa</h1>} />
              <Route path="/course" element={<CourseList />} />
              <Route path="/course/save" element={<CourseKaydetComponent />} />
              <Route path="/course/:id" element={<CourseDetail />} />
              {/* Diğer rotaları ekleyin */}
              <Route path="/user" element={<h1>Kullanıcılar</h1>} />
              <Route path="/user/save" element={<h1>Kullanıcı Ekle</h1>} />
              <Route path="/lesson" element={<h1>Dersler</h1>} />
              <Route path="/lesson/save" element={<h1>Ders Ekle</h1>} />
              <Route path="/review" element={<h1>Yorumlar</h1>} />
              <Route path="/review/save" element={<h1>Yorum Ekle</h1>} />
              <Route path="/teacher" element={<h1>Öğretmenler</h1>} />
              <Route path="/teacher/save" element={<h1>Öğretmen Ekle</h1>} />
              <Route path="/enrollment" element={<h1>Kayıtlar</h1>} />
              <Route path="/enrollment/save" element={<h1>Kayıt Ekle</h1>} />
            </Routes>
          </Col>
        </Row>
      </Container>
    </BrowserRouter>
  );
};

export default App;
