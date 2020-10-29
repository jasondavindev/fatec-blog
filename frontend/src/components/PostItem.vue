<template>
  <div class="mt-3">
    <h2>{{ title }}</h2>
    <p class="post-content">{{ description }}</p>
    <b-button variant="outline-primary" @click="openPost">Abrir post</b-button>
  </div>
</template>

<script>
export default {
  name: 'PostItem',

  props: ['id', 'title', 'description'],

  methods: {
    openPost() {
      this.$router.push(`/posts/${this.id}`);
    },
  },
};
</script>

<style>
</style>
