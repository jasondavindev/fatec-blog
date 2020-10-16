import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080',
});

export default {
  async createPost({ user, title, description }) {
    return axiosInstance.post('/v1/posts', { title, description, user });
  },

  async getPost(postId) {
    return axiosInstance.get(`/v1/posts/${postId}`);
  },

  async getComments(postId) {
    return axiosInstance.get(`/v1/posts/${postId}/comments`);
  },

  async createUser({ name, email }) {
    return axiosInstance.post('/v1/users', { name, email });
  },

  async findUser({ name }) {
    return axiosInstance.get(`/v1/users/${name}`);
  },
};
