import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Card, Spinner } from 'react-bootstrap';
import axiosconfig from '../../Utils/axiosconfig';
import { Course } from '../../Models/Course';

const CourseDetails: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [course, setCourse] = useState<Course | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchCourseById(Number(id));
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

  if (loading) {
    return (
      <div className="text-center">
        <Spinner animation="border" variant="primary" />
        <div>Kurs yükleniyor...</div>
      </div>
    );
  }

  if (!course) {
    return <div>Kurs bulunamadı.</div>;
  }

  return (
    <Card>
      <Card.Body>
        <Card.Title>{course.title}</Card.Title>
        <Card.Text>{course.description}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default CourseDetails;
