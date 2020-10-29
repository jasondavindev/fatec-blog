<template>
  <b-card :title="title" v-if="loaded" class="text-left">
    <div class="post-content">
      <p>{{ description }}</p>
    </div>

    <div class="post-comments" v-if="comments.length">
      <h4>Commentários</h4>
      <div class="comment-card" v-for="(comment, key) in comments" :key="key">
        <CommentCard
          :user="comment.userName"
          :commentary="comment.commentary"
        ></CommentCard>
      </div>
    </div>
  </b-card>
</template>

<script>
import BlogApi from '../services/api';
import CommentCard from './CommentCard';

export default {
  name: 'PostView',

  components: {
    CommentCard,
  },

  data() {
    return {
      comments: [],
      id: null,
      title: null,
      description: null,
      loaded: false,
    };
  },

  async mounted() {
    await this.loadPost();
    await this.getComments();
  },

  methods: {
    setDatas({ id, title, description }) {
      this.id = id;
      this.title = title;
      this.description = description;
    },

    async loadPost() {
      try {
        const {
          data: { id, title, description },
        } = await BlogApi.getPost({ id: this.$route.params.id });

        this.setDatas({ id, title, description });
        this.loaded = true;
      } catch (error) {
        alert('Ocorreu algum erro ao carregar seu post');
      }
    },

    async getComments() {
      try {
        const { data: comments } = await BlogApi.getComments({ id: this.id });

        this.comments = comments;
      } catch (error) {
        alert('Ocorreu um erro inesperado ao carregar seu Post');
      }
    },
  },
};
</script>

<style scoped>
  .post-comments {
    border: solid 1px rgba(0,0,0,0.05);
    border-radius: 3px;
    padding: 12px;
  }

  .post-comments h4 {
    font-size: 18px;
  }
</style>
