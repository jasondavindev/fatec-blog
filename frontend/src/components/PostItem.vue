<template>
  <b-card :title="title">
    <p class="post-content">{{ description }}</p>
    <b-button variant="outline-primary" @click="openPost">Abrir post</b-button>
  </b-card>
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
