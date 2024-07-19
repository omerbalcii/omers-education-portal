// Services/EnrollmentService.tsx

import axios from '../Utils/axiosconfig';

export const fetchEnrollmentList = () => {
  return axios.get('/enrollment');
};

export const fetchEnrollmentById = (id: number) => {
  return axios.get(`/enrollment/${id}`);
};

export const createEnrollment = (enrollmentData: any) => {
  return axios.post('/enrollment', enrollmentData);
};

export const updateEnrollment = (id: number, enrollmentData: any) => {
  return axios.put(`/enrollment/${id}`, enrollmentData);
};

export const deleteEnrollment = (id: number) => {
  return axios.delete(`/enrollment/${id}`);
};
