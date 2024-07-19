// Services/LessonService.tsx

import axios from '../Utils/axiosconfig';

export const fetchLessonList = () => {
  return axios.get('/lesson');
};

export const fetchLessonById = (id: number) => {
  return axios.get(`/lesson/${id}`);
};

export const createLesson = (lessonData: any) => {
  return axios.post('/lesson', lessonData);
};

export const updateLesson = (id: number, lessonData: any) => {
  return axios.put(`/lesson/${id}`, lessonData);
};

export const deleteLesson = (id: number) => {
  return axios.delete(`/lesson/${id}`);
};
