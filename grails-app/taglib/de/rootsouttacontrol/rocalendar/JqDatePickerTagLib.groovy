package de.rootsouttacontrol.rocalendar
import java.lang.ProcessEnvironment.Value;

import org.springframework.web.servlet.support.RequestContextUtils
import java.text.DateFormat

class JqDatePickerTagLib {

	static namespace="roc"

	def jqDatePicker  = { attrs, body ->
		def precision = attrs.precision
		Date value = attrs.value
		def showSeconds = "hidden"
		def showMinutes = "hidden"
		def showHours = "hidden"

		if (precision == "second") {
			showSeconds = "text"
			showMinutes = "text"
			showHours = "text"
		} else if (precision == "minute") {
			showMinutes = "text"
			showHours = "text"
		} else if (precision == "hour") {
			showHours = "text"
		} else if (precision == "day") {
		}

		def name = attrs.name
		def id = attrs.id ?: name
		
		def locale = getLocale()
		String dateFormatPattern = DateFormat.getDateInstance(DateFormat.SHORT, locale).pattern.replace("yy", "yyyy")
		
		//Create date text field and supporting hidden text fields need by grails
		out.println "<input type=\"text\" name=\"${name}\" id=\"${id}_jqDp\" value=\"" + (value ? value?.format(dateFormatPattern) : "" ) + "\" />"
		out.println "<input type=\"hidden\" name=\"${name}_day\" id=\"${id}_day\" value=\"" + (value ? value.date : "" ) + "\" />"
		out.println "<input type=\"hidden\" name=\"${name}_month\" id=\"${id}_month\" value=\"" + (value ? value.month + 1 : "" ) + "\" />"
		out.println "<input type=\"hidden\" name=\"${name}_year\" id=\"${id}_year\" value=\"" + (value ? value.year + 1900 : "" ) + "\" />"
		out.println "<input type=\"text\" size=\"2\" name=\"${name}_hour\" id=\"${id}_hour\" value=\"" + (value ? value.hours : "" ) + "\" /> : "
		out.println "<input type=\"text\" size=\"2\" name=\"${name}_minute\" id=\"${id}_minute\" value=\"" + (value ? value.minutes : "" ) + "\" />"
		out.println "<input type=\"hidden\" size=\"2\" name=\"${name}_second\" id=\"${id}_second\" value=\"" + (value ? value.seconds : "00" ) + "\" />"

		//Code to parse selected date into hidden fields required by grails
		out.println "<script type=\"text/javascript\">"
		out.println "\$(document).ready(function(){"

		out.println "\$.datepicker.setDefaults(\$.datepicker.regional[\"" + locale.getLanguage() + "\"]);"
		out.println "\$(\"#${name}_jqDp\").datepicker("
		out.println "{onClose: function(dateText, inst) {"
		out.println "var day = inst.currentDay;"
		out.println "var month = inst.currentMonth +1;"
		out.println "var year = inst.currentYear;"
		out.println "\$(\"#${name}_day\").attr(\"value\", day);"
		out.println "\$(\"#${name}_month\").attr(\"value\", month);"
		out.println "\$(\"#${name}_year\").attr(\"value\", year);"
		out.println "}}"
		out.println ");"

		out.println "})"

		out.println "</script>"
	}

	private Locale getLocale() {
		RequestContextUtils.getLocale(request)
	}
}
