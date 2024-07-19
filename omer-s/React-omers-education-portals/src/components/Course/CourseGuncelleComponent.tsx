import React, { FormEvent, useEffect, useState } from 'react';
import { Button, Card, Form, Spinner } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';
import axiosconfig from '../../Utils/axiosconfig';
import { Course } from '../../Models/Course';

const CourseGuncelleComponent: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [course, setCourse] = useState<Course | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (id) {
      fetchCourseById(Number(id));
    }
  }, [id]);

  const fetchCourseById = async (courseId: number) => {
    try {
      const response = await axiosconfig.get<Course>(`/course/${courseId}`);
      setCourse(response.data);
    } catch (error) {
      console.error(`Error fetching course with id ${courseId}:`, error);
    } finally {
      setLoading(false);
    }
  };

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (!course) return;

    setLoading(true);

    try {
      await axiosconfig.put(`/course/${id}`, course);
      navigate('/courses');
    } catch (error) {
      console.error('Error updating course:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = event.target;
    if (course) {
      setCourse({ ...course, [name]: value });
    }
  };

  if (loading) {
    return (
      <div className="text-center">
        <Spinner animation="border" variant="primary" />
        <div>Kurs yükleniyor...</div>
      </div>
    );
  }

  return (
    <Card>
      <Card.Body>
        <Card.Title>Kurs Güncelle</Card.Title>
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3" controlId="formTitle">
            <Form.Label>Başlık</Form.Label>
            <Form.Control
              type="text"
              placeholder="Kurs başlığını giriniz"
              name="title"
              value={course?.title || ''}
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
              value={course?.description || ''}
              onChange={handleInputChange}
              rows={3}
              required
            />
          </Form.Group>

          {loading ? (
            <Spinner animation="border" variant="primary" />
          ) : (
            <Button variant="primary" type="submit">
              Güncelle
            </Button>
          )}
        </Form>
      </Card.Body>
    </Card>
  );
};

export default CourseGuncelleComponent;
