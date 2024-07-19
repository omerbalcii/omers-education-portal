// CourseService.ts
import axios from 'axios';
import { Course } from '../Models/Course';

const BASE_URL = 'http://localhost:8081/course';

export const getAllCourses = async (): Promise<Course[]> => {
  try {
    const response = await axios.get<Course[]>(`${BASE_URL}/getall`);
    return response.data;
  } catch (error) {
    console.error('Error fetching courses:', error);
    throw error;
  }
};

export const getCourseById = async (id: number): Promise<Course | null> => {
  try {
    const response = await axios.get<Course>(`${BASE_URL}/getbyid/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error fetching course with id ${id}:`, error);
    throw error;
  }
};

export const saveCourse = async (course: Course): Promise<Course> => {
  try {
    const response = await axios.post<Course>(`${BASE_URL}/save`, course);
    return response.data;
  } catch (error) {
    console.error('Error saving course:', error);
    throw error;
  }
};

export const updateCourse = async (id: number, course: Course): Promise<Course> => {
  try {
    const response = await axios.put<Course>(`${BASE_URL}/update/${id}`, course);
    return response.data;
  } catch (error) {
    console.error(`Error updating course with id ${id}:`, error);
    throw error;
  }
};

export const deleteCourse = async (id: number): Promise<boolean> => {
  try {
    const response = await axios.delete(`${BASE_URL}/delete/${id}`);
    return response.status === 200;
  } catch (error) {
    console.error(`Error deleting course with id ${id}:`, error);
    throw error;
  }
};
