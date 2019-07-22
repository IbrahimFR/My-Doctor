var _email = document.getElementById('_email');

var _password = document.getElementById('_password');

var __form = document.getElementById('__form');

function login_email_Valid() {
// not for Email It's for UserName just changing in REG Mkotkot .. 
	if (!_email.value
			.match(/^[\u0600-\u06FF]/)) {
		_email.style.border = '1px solid #ff1703';

		return true;
	} else {
		_email.style.border = '1px solid #E3E3E3';

		return false;
	}

}

function login_password_Valid() {

	if (!_password.value.match(/^[a-zA-Z0-9\s]{6,60}$/)) {
		_password.style.border = '1px solid #ff1703';

		return true;
	} else {
		_password.style.border = '1px solid #E3E3E3';

		return false;
	}

}

function login_form_Valid() {
	if (login_email_Valid() || login_password_Valid()) {

		$(__form).removeClass('hidden');
		return false;
	} else {
		$(__form).addClass('hidden');
		return true;
	}

}
