package tech.simter.auth.po.base

/**
 * A enum status with a persistence value.
 *
 * @author RJ
 */
interface PersistenceStatus {
  /** The persistence value */
  val value: Short
  /** The enum name */
  val name: String
}