package com.huynn109.chappiebothometest.util.extension

import android.app.Activity
import android.app.AlarmManager
import android.app.KeyguardManager
import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.content.ActivityNotFoundException
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Context.DEVICE_POLICY_SERVICE
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.content.Context.KEYGUARD_SERVICE
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Context.TELEPHONY_SERVICE
import android.content.Intent
import android.content.Intent.EXTRA_SUBJECT
import android.content.Intent.EXTRA_TEXT
import android.content.Intent.createChooser
import android.net.ConnectivityManager
import android.os.Build.VERSION_CODES
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.core.app.ActivityOptionsCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

/**
 * Created by huynn109 on 4/10/19.
 */

/**
 * Extension method to provide simpler access to { @link ContextCompat#getColor(int) }.
 */
fun Context.getColorCompat(color: Int) = ContextCompat.getColor(this, color)

/**
 * Extension method to find a device width in pixels
 */
inline val Context.displayWidth: Int
  get() = resources.displayMetrics.widthPixels
/**
 * Extension method to find a device height in pixels
 */
inline val Context.displayHeight: Int
  get() = resources.displayMetrics.heightPixels
/**
 * Extension method to get displayMetrics in Context.displayMetricks
 */
inline val Context.displayMetricks: DisplayMetrics
  get() = resources.displayMetrics
/**
 * Extension method to get LayoutInflater
 */
inline val Context.inflater: LayoutInflater
  get() = LayoutInflater.from(this)

/**
 * Extension method to get a new Intent for an Activity class
 */
inline fun <reified T : Any> Context.intent() = Intent(this, T::class.java)

/**
 * Create an intent for [T] and apply a lambda on it
 */
inline fun <reified T : Any> Context.intent(body: Intent.() -> Unit): Intent {
  val intent = Intent(this, T::class.java)
  intent.body()
  return intent
}

/**
 * Extension method to startActivity for Context.
 */
inline fun <reified T : Activity> Context?.startActivity() =
  this?.startActivity(Intent(this, T::class.java))

/**
 * Extension method to start Service for Context.
 */
inline fun <reified T : Service> Context?.startService() =
  this?.startService(Intent(this, T::class.java))

/**
 * Extension method to startActivity with Animation for Context.
 */
inline fun <reified T : Activity> Context.startActivityWithAnimation(
  enterResId: Int = 0,
  exitResId: Int = 0
) {
  val intent = Intent(this, T::class.java)
  val bundle = ActivityOptionsCompat.makeCustomAnimation(this, enterResId, exitResId)
      .toBundle()
  ContextCompat.startActivity(this, intent, bundle)
}

/**
 * Extension method to startActivity with Animation for Context.
 */
inline fun <reified T : Activity> Context.startActivityWithAnimation(
  enterResId: Int = 0,
  exitResId: Int = 0,
  intentBody: Intent.() -> Unit
) {
  val intent = Intent(this, T::class.java)
  intent.intentBody()
  val bundle = ActivityOptionsCompat.makeCustomAnimation(this, enterResId, exitResId)
      .toBundle()
  ContextCompat.startActivity(this, intent, bundle)
}

/**
 * Extension method to show toast for Context.
 */
fun Context?.toast(
  text: CharSequence,
  duration: Int = Toast.LENGTH_LONG
) =
  this?.let {
    Toast.makeText(it, text, duration)
        .show()
  }

/**
 * Extension method to show toast for Context.
 */
fun Context?.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_LONG) =
  this?.let {
    Toast.makeText(it, textId, duration)
        .show()
  }

/**
 * Extension method to Get Integer resource for Context.
 */
fun Context.getInteger(@IntegerRes id: Int) = resources.getInteger(id)

/**
 * Extension method to Get Boolean resource for Context.
 */
fun Context.getBoolean(@BoolRes id: Int) = resources.getBoolean(id)

/**
 * InflateLayout
 */
fun Context.inflateLayout(
  @LayoutRes layoutId: Int, parent: ViewGroup? = null,
  attachToRoot: Boolean = false
): View = LayoutInflater.from(this).inflate(layoutId, parent, attachToRoot)

/**
 * Extension method to get inputManager for Context.
 */
inline val Context.inputManager: InputMethodManager?
  get() = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
/**
 * Extension method to get notificationManager for Context.
 */
inline val Context.notificationManager: NotificationManager?
  get() = getSystemService(NOTIFICATION_SERVICE) as? NotificationManager
/**
 * Extension method to get keyguardManager for Context.
 */
inline val Context.keyguardManager: KeyguardManager?
  get() = getSystemService(KEYGUARD_SERVICE) as? KeyguardManager
/**
 * Extension method to get telephonyManager for Context.
 */
inline val Context.telephonyManager: TelephonyManager?
  get() = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
/**
 * Extension method to get devicePolicyManager for Context.
 */
inline val Context.devicePolicyManager: DevicePolicyManager?
  get() = getSystemService(DEVICE_POLICY_SERVICE) as? DevicePolicyManager
/**
 * Extension method to get connectivityManager for Context.
 */
inline val Context.connectivityManager: ConnectivityManager?
  get() = getSystemService(CONNECTIVITY_SERVICE) as? ConnectivityManager
/**
 * Extension method to get alarmManager for Context.
 */
inline val Context.alarmManager: AlarmManager?
  get() = getSystemService(ALARM_SERVICE) as? AlarmManager
/**
 * Extension method to get clipboardManager for Context.
 */
inline val Context.clipboardManager: ClipboardManager?
  get() = getSystemService(CLIPBOARD_SERVICE) as? ClipboardManager
/**
 * Extension method to get jobScheduler for Context.
 */
inline val Context.jobScheduler: JobScheduler?
  @RequiresApi(VERSION_CODES.LOLLIPOP)
  get() = getSystemService(JOB_SCHEDULER_SERVICE) as? JobScheduler

/**
 * Extension method to show notification for Context.
 */
inline fun Context.notification(
  body: NotificationCompat.Builder.() -> Unit,
  channelId: String
): Notification {
  val builder = NotificationCompat.Builder(this, channelId)
  builder.body()
  return builder.build()
}

/**
 * Extension method to share for Context.
 */
fun Context.share(
  text: String,
  subject: String = ""
): Boolean {
  val intent = Intent()
  intent.type = "text/plain"
  intent.putExtra(EXTRA_SUBJECT, subject)
  intent.putExtra(EXTRA_TEXT, text)
  try {
    startActivity(createChooser(intent, null))
    return true
  } catch (e: ActivityNotFoundException) {
    return false
  }
}

/**
 * Extension method to provide quicker access to the [LayoutInflater] from [Context].
 */
fun Context.getLayoutInflater() =
  getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

/**
 * Extension method to provide quicker access to the [Drawable] from [Context].
 */
fun Context.getDrawableCompat(drawableId: Int) = ContextCompat.getDrawable(this, drawableId)

