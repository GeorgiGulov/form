package redax
import redux.RAction

class MarkStudent(val lessonName: String, val studentId: String): RAction


class setEmail(val str: String): RAction
class setPassword(val str: String): RAction

class setEmailDirty(val bool: Boolean): RAction
class setPasswordDirty(val bool: Boolean): RAction

class setEmailError(val str: String): RAction
class setPasswordError(val str: String): RAction

class setFormValid(val bool: Boolean): RAction