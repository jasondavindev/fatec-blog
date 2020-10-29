import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080',
});

export default {
  async createPost({ user, title, description }) {
    return axiosInstance.post('/v1/posts', { title, description, user });
  },

  async getPost({ id }) {
    return axiosInstance.get(`/v1/posts/${id}`);
  },

  async getComments({ id }) {
    return axiosInstance.get(`/v1/posts/${id}/comments`);
  },

  async createUser({ name, email }) {
    return axiosInstance.post('/v1/users', { name, email });
  },

  async userLogin({ email }) {
    return axiosInstance.post('/v1/users/login', { email });
  },

  async userPosts({ id }) {
    return axiosInstance.get(`/v1/posts/user/${id}`);
  },
};
