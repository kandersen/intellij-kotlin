/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.uast.kotlin

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiType
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.types.typeUtil.TypeNullability
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UExpression
import org.jetbrains.uast.UNamedExpression
import org.jetbrains.uast.UastCallKind

interface BaseKotlinUastResolveProviderService {
    fun isJvmElement(psiElement: PsiElement): Boolean

    // ----------
    // Conversion
    // ----------

    val baseKotlinConverter: BaseKotlinConverter

    fun convertParent(uElement: UElement): UElement?

    fun convertParent(uElement: UElement, parent: PsiElement?): UElement?

    fun convertValueArguments(ktCallElement: KtCallElement, parent: UElement): List<UNamedExpression>?

    fun findDefaultValueForAnnotationAttribute(ktCallElement: KtCallElement, name: String): KtExpression?

    fun getArgumentForParameter(ktCallElement: KtCallElement, index: Int, parent: UElement): UExpression?

    fun getImplicitReturn(ktLambdaExpression: KtLambdaExpression, parent: UElement): KotlinUImplicitReturnExpression?

    fun getImplicitParameters(ktLambdaExpression: KtLambdaExpression, parent: UElement): List<KotlinUParameter>

    // ----------
    // Resolution
    // ----------

    fun getReferenceVariants(ktExpression: KtExpression, nameHint: String): Sequence<PsiElement>

    fun resolveCall(ktElement: KtElement): PsiMethod?

    fun isResolvedToExtension(ktCallElement: KtCallElement): Boolean

    fun resolvedFunctionName(ktCallElement: KtCallElement): String?

    fun qualifiedAnnotationName(ktCallElement: KtCallElement): String?

    fun callKind(ktCallElement: KtCallElement): UastCallKind

    fun isAnnotationConstructorCall(ktCallElement: KtCallElement): Boolean

    fun resolveToClassIfConstructorCall(ktCallElement: KtCallElement, source: UElement): PsiClass?

    fun resolveToClass(ktAnnotationEntry: KtAnnotationEntry): PsiClass?

    fun resolveToDeclaration(ktExpression: KtExpression): PsiElement?

    fun resolveToType(ktTypeReference: KtTypeReference, source: UElement): PsiType?

    // ----------
    // Types
    // ----------

    fun getReceiverType(ktCallElement: KtCallElement, source: UElement): PsiType?

    fun getDoubleColonReceiverType(ktDoubleColonExpression: KtDoubleColonExpression, source: UElement): PsiType?

    fun getCommonSupertype(left: KtExpression, right: KtExpression, uExpression: UExpression): PsiType?

    fun getType(ktExpression: KtExpression, parent: UElement): PsiType?

    fun getType(ktDeclaration: KtDeclaration, parent: UElement): PsiType?

    fun getFunctionType(ktFunction: KtFunction, parent: UElement): PsiType?

    fun getFunctionalInterfaceType(uLambdaExpression: KotlinULambdaExpression): PsiType?

    fun nullability(psiElement: PsiElement): TypeNullability?

    // ----------
    // Evaluation
    // ----------

    fun evaluate(uExpression: UExpression): Any?
}
