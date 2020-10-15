<template>
  <div class="m-4 text-left">
    <b-card>
      <div>
        <h1>{{ post.title }}</h1>
        <p>{{ post.description }}</p>
      </div>
    </b-card>
    <b-card>
      <div>
        <h3 class="mt-3">Comentários</h3>
        <div class="post-comments mt-4">
          <div
            class="comment-card"
            v-for="(comment, index) in post.comments"
            :key="index"
          >
            <CommentCard
              :user="comment.userName"
              :commentary="comment.commentary"
            ></CommentCard>
          </div>
        </div>
      </div>
    </b-card>
  </div>
</template>

<script>
import BlogApi from '../services/api';
import CommentCard from './CommentCard';

export default {
  components: {
    CommentCard,
  },
  data() {
    return {
      postId: 1,
      user: 1,
      post: {
        title: '',
        description: '',
        comments: [],
      },
    };
  },
  methods: {
    async getPost(postId) {
      try {
        const { data } = await BlogApi.getPost(postId);
        return data;
      } catch (error) {
        return console.error(error);
      }
    },
    async getComments(postId) {
      try {
        const { data } = await BlogApi.getComments(postId);
        return data;
      } catch (error) {
        return console.error(error);
      }
    },
  },

  async mounted() {
    const post = await this.getPost(this.postId);
    const comments = await this.getComments(this.postId);

    this.post.title = post.title;
    this.post.description = post.description;
    this.post.comments = comments;
  },
};
</script>

<style>
</style>
