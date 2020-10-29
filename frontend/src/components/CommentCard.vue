<template>
  <div class="comment-card">
    <span class="comment-user">{{ this.user }}:</span>
    <span class="comment-content">{{ this.commentary }}</span>
  </div>
</template>

<script>
export default {
  props: ['user', 'commentary'],
};
</script>

<style scoped>
.comment-user {
  font-size: 16px;
  font-weight: bold;
}

.comment-content {
  font-size: 14px;
}

.comment-card {
  margin-bottom: 12px;
}
</style>
