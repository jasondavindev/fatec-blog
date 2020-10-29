<template>
  <div class="mt-3 text-left">
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
    await this.getUserPosts();
  },

  methods: {
    async getUserPosts() {
      try {
        const { id } = this.user;
        const { data: posts } = await BlogApi.userPosts({ id });
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
