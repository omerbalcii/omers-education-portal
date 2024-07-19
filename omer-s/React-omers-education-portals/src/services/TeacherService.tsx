// Services/TeacherService.tsx

import axios from '../Utils/axiosconfig';

export const fetchTeacherList = () => {
  return axios.get('/teacher');
};

export const fetchTeacherById = (id: number) => {
  return axios.get(`/teacher/${id}`);
};

export const createTeacher = (teacherData: any) => {
  return axios.post('/teacher', teacherData);
};

export const updateTeacher = (id: number, teacherData: any) => {
  return axios.put(`/teacher/${id}`, teacherData);
};

export const deleteTeacher = (id: number) => {
  return axios.delete(`/teacher/${id}`);
};
