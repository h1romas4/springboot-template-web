import Vue from 'vue';
import axios from 'axios';

new Vue({
    el: '#vue-module',
    data: {
        items: []
    },
    mounted: function() {
        this.ajax();
    },
    methods: {
        ajax: function() {
            axios.get('/vue').then((res) => {
                this.items = res.data;
            });
        }
    }
});
