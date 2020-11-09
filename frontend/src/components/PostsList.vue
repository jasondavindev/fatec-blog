<template>
  <div class="mt-3">
    <b-card class="text-center" v-if="!posts.length">
      <h4>Que triste ... Não há nenhum post no momento ;-(</h4>
    </b-card>
    <div v-for="(post, key) in posts" :key="key" class="post-item">
      <PostItem
        :id="post.id"
        :title="post.title"
        :description="post.description"
      ></PostItem>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import BlogApi from '../services/api';
import PostItem from './PostItem';

export default {
  name: 'PostsList',

  components: {
    PostItem,
  },

  data() {
    return {
      posts: [],
    };
  },

  computed: {
    ...mapGetters(['user']),
  },

  async mounted() {
    await this.getPosts();
  },

  methods: {
    async getPosts() {
      try {
        const { id } = this.user;
        const { data: posts } = await BlogApi.getAllPosts();
        this.posts = posts;
      } catch (error) {
        alert('Ocorreu um erro');
      }
    },
  },
};
</script>

<style scoped>
.post-item {
  padding: 10px;
}
</style>
