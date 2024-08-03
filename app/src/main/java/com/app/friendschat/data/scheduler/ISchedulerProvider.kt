package com.app.friendschat.data.scheduler

import io.reactivex.Scheduler

interface ISchedulerProvider {
    val computation: Scheduler
    val io: Scheduler
    val ui: Scheduler
}