module.exports = function(grunt)
{
    grunt.initConfig({
        less: {
            development: {
                files: {
                    'dist/css/nav.css': 'src/less/nav.less'
                    'dist/css/footer.css': 'src/less/footer.less'
                    'dist/css/jumbotron.css': 'src/less/jumbotron.less'
                }
            }
        },
        watch: {
            less: {
                files: ['**/*.less'],
                tasks: ['less']
            },
        },
    });

    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-jshint');
};
