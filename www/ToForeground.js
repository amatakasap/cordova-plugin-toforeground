var exec = require('cordova/exec');

var toForeground = function(main_class_name, package_name, success, error) {
  exec(success, error, 'ToForeground', 'toForeground', [main_class_name, package_name]);
};

module.exports = toForeground;
