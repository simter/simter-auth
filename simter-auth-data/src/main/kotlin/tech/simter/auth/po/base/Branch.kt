package tech.simter.auth.po.base

import tech.simter.auth.po.Company
import tech.simter.auth.po.Department

/**
 * A Branch belongs to a parent Branch or it's a top Branch without parent..
 *
 * Branch is the abstraction of [Company] and [Department].
 *
 * @author RJ
 */
interface Branch : Organization