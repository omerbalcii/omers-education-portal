// Services/UserService.tsx

import axios from '../Utils/axiosconfig';

export const fetchUserList = () => {
  return axios.get('/user');
};

export const fetchUserById = (id: number) => {
  return axios.get(`/user/${id}`);
};

export const createUser = (userData: any) => {
  return axios.post('/user', userData);
};

export const updateUser = (id: number, userData: any) => {
  return axios.put(`/user/${id}`, userData);
};

export const deleteUser = (id: number) => {
  return axios.delete(`/user/${id}`);
};
