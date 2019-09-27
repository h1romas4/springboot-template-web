import Vue from 'vue';
import axios from 'axios';
import hello from '../common/hello'

new Vue({
    el: '#vue-module',
    components: {
        'hello': hello
    },
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
