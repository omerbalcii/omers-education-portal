// Services/ReviewService.tsx

import axios from '../Utils/axiosconfig';

export const fetchReviewList = () => {
  return axios.get('/review');
};

export const fetchReviewById = (id: number) => {
  return axios.get(`/review/${id}`);
};

export const createReview = (reviewData: any) => {
  return axios.post('/review', reviewData);
};

export const updateReview = (id: number, reviewData: any) => {
  return axios.put(`/review/${id}`, reviewData);
};

export const deleteReview = (id: number) => {
  return axios.delete(`/review/${id}`);
};
