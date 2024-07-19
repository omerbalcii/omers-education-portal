import React, { FormEvent, useState } from 'react';
import { Button, Card, Form, Spinner } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import axiosconfig from '../../Utils/axiosconfig';
import { Course } from '../../Models/Course'; // Dosya yolunu güncelledik

const CourseKaydetComponent: React.FC = () => {
  const navigate = useNavigate();
  const [course, setCourse] = useState<Course>({
    id: 0,
    name: '', // Burada name kullanıyoruz
    title: '',
    description: '',
    lessons: [],
    reviews: [],
    enrollments: []
  });
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setLoading(true);

    try {
      // API URL'sini güncelledik
      await axiosconfig.post('/course/save', JSON.stringify(course), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      navigate('/course');
    } catch (error) {
      console.error('Error saving course:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = event.target;
    setCourse({ ...course, [name]: value });
  };

  return (
    <Card>
      <Card.Body>
        <Card.Title>Yeni Kurs Oluştur</Card.Title>
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3" controlId="formName">
            <Form.Label>İsim</Form.Label>
            <Form.Control
              type="text"
              placeholder="Kurs ismini giriniz"
              name="name" // Burada name olmalı
              value={course.name}
              onChange={handleInputChange}
              required
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formTitle">
            <Form.Label>Başlık</Form.Label>
            <Form.Control
              type="text"
              placeholder="Kurs başlığını giriniz"
              name="title"
              value={course.title}
              onChange={handleInputChange}
              required
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formDescription">
            <Form.Label>Açıklama</Form.Label>
            <Form.Control
              as="textarea"
              placeholder="Kurs açıklamasını giriniz"
              name="description"
              value={course.description}
              onChange={handleInputChange}
              rows={3}
              required
            />
          </Form.Group>

          {loading ? (
            <Spinner animation="border" variant="primary" />
          ) : (
            <Button variant="primary" type="submit">
              Kaydet
            </Button>
          )}
        </Form>
      </Card.Body>
    </Card>
  );
};

export default CourseKaydetComponent;
