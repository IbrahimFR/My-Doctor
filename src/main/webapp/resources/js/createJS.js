var arr = [ 'Natural Language Processing', 'K-means Clustering',
		'Automated Text Summarization', 'Optical Character Recognition',
		' Content Recommendation', 'Image Classification' ];

window.onload = myfun1;
var i = 0;
function myfun1() {
	i = setInterval(function() {
		document.getElementById('s01').innerHTML = arr[i] + " ";

		i++;
		if (i >= 6) {
			clearInterval(i);

			i = 0;
		}
	}, 5000);
}

// profile validation for client side
var _doctorName = document.getElementById('_doctorName');
var _specialization = document.getElementById('_specialization');
var _email = document.getElementById('_email');
var _mobile = document.getElementById('_mobile');
var _descreprtion = document.getElementById('_descreprtion');


var __form = document.getElementById('__form');



var _right_mark_doctorName = document.getElementById('right_mark_doctorName');
var _right_mark_specialization = document.getElementById('right_mark_specialization');
var _right_mark_email = document.getElementById('right_mark_email');
var _right_mark_mobile = document.getElementById('right_mark_mobile');
var _right_mark_Password = document.getElementById('right_mark_Password');
var _right_mark_REpassword = document.getElementById('right_mark_REpassword');

function NameVaildation() {
	if (!_doctorName.value.match(/^[a-zA-Z0-9]{2,50}$/)) {
		_doctorName.style.border = '1px solid #ff1703';
		$(_right_mark_doctorName).addClass('hidden');
		return true;
	} else {
		_doctorName.style.border = '1px solid #E3E3E3';
		$(_right_mark_doctorName).removeClass('hidden');
		return false;
	}
}

function NameVaildation() {
	if (!_doctorName.value.match(/^[a-zA-Z]{2,50}$/)) {
		_doctorName.style.border = '1px solid #ff1703'; // red

		$(_right_mark_doctorName).addClass('hidden');
		return true;
	} else {
		_doctorName.style.border = '1px solid #E3E3E3';

		$(_right_mark_doctorName).removeClass('hidden');
		return false;
	}
}

function specializationVaildation() {
	if (!_specialization.value.match(/^[a-zA-Z]{2,50}$/)) {
		_specialization.style.border = '1px solid #ff1703';

		$(_right_mark_specialization).addClass('hidden');
		return true;
	} else {
		_specialization.style.border = '1px solid #E3E3E3';

		$(_right_mark_specialization).removeClass('hidden');
		return false;
	}
}

function EmailVaildation() {
	if (!_email.value
			.match(/^[A-Za-z0-9/._/]{2,40}[@][A-Za-z]{2,9}[/.][A-Za-z]{2,9}$/)) {
		_email.style.border = '1px solid #ff1703';

		$(_right_mark_email).addClass('hidden');
		return true;
	} else {
		_email.style.border = '1px solid #E3E3E3';

		$(_right_mark_email).removeClass('hidden');
		return false;
	}
}

function userPasswordVaildation() {
	if (!_password.value.match(/^[a-zA-Z0-9\s]{6,60}$/)) {
		_password.style.border = '1px solid #ff1703';
		$(_right_mark_Password).addClass('hidden');
		return true;
	} else {
		_password.style.border = '1px solid #E3E3E3';

		$(_right_mark_Password).removeClass('hidden');
		return false;
	}
}

function userREpasswordVaildation() {
	if (!_rePassword.value.match(/^[a-zA-Z0-9\s]{6,60}$/)) {
		_rePassword.style.border = '1px solid #ff1703';
		$(_right_mark_REpassword).addClass('hidden');
		return true;
	} else {
		var nn = _rePassword.value.localeCompare(_password.value);
		console.log(_rePassword.value);
		console.log(_password.value);
		console.log(nn);
		if (nn != 0) {
			_rePassword.style.border = '1px solid #ff1703';
			$(_right_mark_REpassword).addClass('hidden');
			return true
		} else {
			_rePassword.style.border = '1px solid #E3E3E3';
			$(_right_mark_REpassword).removeClass('hidden');
			return false
		}
	}
}

function RuserNameVaildation() {
	$(_right_mark_doctorName).addClass('hidden');

}

function RuserVaildation() {

	$(_right_mark_doctorName).addClass('hidden');

}

function RuserspecializationVaildation() {

	$(_right_mark_specialization).addClass('hidden');

}

function RuserEmailVaildation() {
	$(_right_mark_email).addClass('hidden');

}

function RuserPasswordVaildation() {

	$(_right_mark_Password).addClass('hidden');

}

function RuserREpasswordVaildation() {
	$(_right_mark_REpassword).addClass('hidden');
}



function user_form_Valid() {

	if (__privacyPolicy.checked) {
		__policy.style.border = '1px solid #007AFF';

		if (NameVaildation() || specializationVaildation()
				|| NameVaildation() || EmailVaildation()
				) {

			$(__form).removeClass('hidden');
			// alert('false');
			return false;
		} else {

			$(__form).addClass('hidden');
			// alert('truee');
			return true;
		}

	} else {
		$(__form).removeClass('hidden');
		__policy.style.border = '1px solid #ff1703';
		// alert('not checked ');
		return false;
	}

}