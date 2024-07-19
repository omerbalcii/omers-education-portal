// CourseList.tsx
import React, { useEffect, useState } from 'react';
import { Button, Card, Spinner, Table } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import { getAllCourses, deleteCourse } from '../../services/CourseService'; // `getAllCourses` burada kullanılmalı
import { Course } from '../../Models/Course';

const CourseList: React.FC = () => {
  const [courses, setCourses] = useState<Course[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    try {
      const coursesData = await getAllCourses();
      setCourses(coursesData);
    } catch (error) {
      console.error('Error fetching courses:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async (id: number) => {
    try {
      await deleteCourse(id);
      setCourses(courses.filter((course) => course.id !== id));
    } catch (error) {
      console.error(`Error deleting course with id ${id}:`, error);
    }
  };

  if (loading) {
    return (
      <div className="text-center">
        <Spinner animation="border" variant="primary" />
        <div>Kurslar yükleniyor...</div>
      </div>
    );
  }

  return (
    <Card>
      <Card.Body>
        <Card.Title>Kurs Listesi</Card.Title>
        <Table responsive striped bordered>
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>Başlık</th>
              <th>Açıklama</th>
              <th>Detay</th>
              <th>Güncelle</th>
              <th>Sil</th>
            </tr>
          </thead>
          <tbody>
            {courses.map((course) => (
              <tr key={course.id}>
                <td>{course.id}</td>
                <td>{course.title}</td>
                <td>{course.description}</td>
                <td>
                  <NavLink className="btn btn-outline-primary" to={`/course/details/${course.id}`}>
                    Detay
                  </NavLink>
                </td>
                <td>
                  <NavLink className="btn btn-outline-success" to={`/course/update/${course.id}`}>
                    Güncelle
                  </NavLink>
                </td>
                <td>
                  <Button variant="outline-danger" onClick={() => handleDelete(course.id)}>
                    Sil
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Card.Body>
    </Card>
  );
};

export default CourseList;
